package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableCommentByUser;
import static com.datastax.samples.schema.SchemaUtils.createTableCommentByVideo;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BatchStatement;
import com.datastax.oss.driver.api.core.cql.BatchType;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.samples.schema.SchemaConstants;

public class E04_Batches implements SchemaConstants {
    
    /** Logger for the class. */
    private static Logger LOGGER = LoggerFactory.getLogger(E04_Batches.class);
    
    // Prepare your statements once and execute multiple times 
    private static PreparedStatement insertIntoCommentByVideo;
    private static PreparedStatement insertIntoCommentByUser;
    private static PreparedStatement deleteCommentByVideo;
    private static PreparedStatement deleteCommentByUser;
    private static PreparedStatement selectCommentByVideo;
    private static PreparedStatement selectCommentByUser;
    
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
   
            // Create working table User (if needed)
            createTableCommentByUser(cqlSession);
            createTableCommentByVideo(cqlSession);
            
            // Comments are used in 2 queries, we need 2 tables to store it
            truncateTable(cqlSession, COMMENT_BY_USER_TABLENAME);
            truncateTable(cqlSession, COMMENT_BY_VIDEO_TABLENAME);

            // Prepare your statements once and execute multiple times 
            prepareStatements(cqlSession);

            // Will use this identifiers is all tests
            UUID user_1    = UUID.randomUUID();UUID user_2    = UUID.randomUUID();
            UUID videoid_1 = UUID.randomUUID();UUID videoid_2 = UUID.randomUUID();
            
            /* ==================== CREATE =====================
             * Create comment (in 2 tables with BATCH)
             * ================================================= */
            
            UUID commentId11 = createComment(cqlSession, user_1, videoid_1, "I am user1 and video1 is good");
            UUID commentId21 = createComment(cqlSession, user_2, videoid_1, "I am user2 and video2 is bad");
            createComment(cqlSession, user_1, videoid_2, "Video2 is cool");
            createComment(cqlSession, user_2, videoid_2, "Video2");
            retrieveCommentsVideo(cqlSession, videoid_2).stream().forEach(LOGGER::info);
            
            /* =============== UPDATE ==========================
             * == Update one comment (in 2 tables with BATCH) ==
             * ================================================= */
            
            updateComment(cqlSession, commentId11, user_1, videoid_1, "This is my new comment");
            retrieveCommentsVideo(cqlSession, videoid_1).stream().forEach(LOGGER::info);
            
            /* =============== DELETE ===========================
             * Delete one comment (in 2 tables with BATCH)     ==
             * Note that commentId is NOT ENOUGH as userid and ==
             * videoid are part of the the primary keys.       ==
             * ==================================================*/
            
            deleteComment(cqlSession, commentId21, user_2, videoid_1);
            retrieveCommentsVideo(cqlSession, videoid_1).stream().forEach(LOGGER::info);
            
            /* 
             * ============================ READ ================================
             * == Query1: List comments for user_1 with table comment_by_user   =
             * == Query2: List comments for video_2 with table comment_by_video =
             * ==================================================================
             */
            
            retrieveCommentsUser(cqlSession, user_1).stream().forEach(LOGGER::info);
            retrieveCommentsVideo(cqlSession, videoid_2).stream().forEach(LOGGER::info);
            
        }
    }
    
    private static void prepareStatements(CqlSession cqlSession) {
        
        insertIntoCommentByVideo = cqlSession.prepare(
                QueryBuilder.insertInto(COMMENT_BY_VIDEO_TABLENAME)
                            .value(COMMENT_BY_VIDEO_VIDEOID,   QueryBuilder.bindMarker())
                            .value(COMMENT_BY_VIDEO_USERID,    QueryBuilder.bindMarker())
                            .value(COMMENT_BY_VIDEO_COMMENTID, QueryBuilder.bindMarker())
                            .value(COMMENT_BY_VIDEO_COMMENT,   QueryBuilder.bindMarker())
                            .build());
        insertIntoCommentByUser = cqlSession.prepare(
                QueryBuilder.insertInto(COMMENT_BY_USER_TABLENAME)
                            .value(COMMENT_BY_USER_USERID,     QueryBuilder.bindMarker())
                            .value(COMMENT_BY_USER_VIDEOID,    QueryBuilder.bindMarker())
                            .value(COMMENT_BY_USER_COMMENTID,  QueryBuilder.bindMarker())
                            .value(COMMENT_BY_USER_COMMENT,    QueryBuilder.bindMarker())
                            .build());
        
        deleteCommentByUser = cqlSession.prepare(
                QueryBuilder.deleteFrom(COMMENT_BY_USER_TABLENAME)
                .whereColumn(COMMENT_BY_USER_USERID).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(COMMENT_BY_USER_COMMENTID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        deleteCommentByVideo = cqlSession.prepare(
                QueryBuilder.deleteFrom(COMMENT_BY_VIDEO_TABLENAME)
                .whereColumn(COMMENT_BY_VIDEO_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(COMMENT_BY_VIDEO_COMMENTID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
        selectCommentByVideo = cqlSession.prepare(
                QueryBuilder.selectFrom(COMMENT_BY_VIDEO_TABLENAME)
                .column(COMMENT_BY_VIDEO_COMMENT)
                .whereColumn(COMMENT_BY_VIDEO_VIDEOID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        selectCommentByUser  = cqlSession.prepare(
                QueryBuilder.selectFrom(COMMENT_BY_USER_TABLENAME)
                .column(COMMENT_BY_USER_COMMENT)
                .whereColumn(COMMENT_BY_USER_USERID).isEqualTo(QueryBuilder.bindMarker())
                .build());
    }

    
    private static UUID createComment(CqlSession cqlSession, UUID userid, UUID videoid, String comment) {
        UUID commentid = Uuids.timeBased();
        updateComment(cqlSession, commentid, userid, videoid, comment);
        return commentid;
    }
     
    private static void updateComment(CqlSession cqlSession, UUID commentid, UUID userid, UUID videoid, String comment) {
        cqlSession.execute(BatchStatement
                .builder(BatchType.LOGGED)
                .addStatement(insertIntoCommentByVideo.bind(videoid, userid, commentid, comment))
                .addStatement(insertIntoCommentByUser.bind(userid, videoid, commentid, comment))
                .build());
    }
    
    private static void deleteComment(CqlSession cqlSession, UUID commentid, UUID userid, UUID videoid) {
        cqlSession.execute(BatchStatement
                .builder(BatchType.LOGGED)
                .addStatement(deleteCommentByUser.bind(userid, commentid))
                .addStatement(deleteCommentByVideo.bind(videoid, commentid))
                .build());
    }
    
    private static List<String> retrieveCommentsVideo(CqlSession cqlSession, UUID videoid) {
        return cqlSession.execute(selectCommentByVideo.bind(videoid))
               .all().stream().map(row -> row.getString(COMMENT_BY_VIDEO_COMMENT))
               .collect(Collectors.toList());
    }
    
    private static List<String> retrieveCommentsUser(CqlSession cqlSession, UUID userId) {
        return cqlSession.execute(selectCommentByUser.bind(userId))
                .all().stream().map(row -> row.getString(COMMENT_BY_USER_COMMENT))
                .collect(Collectors.toList());
    }
    
}

