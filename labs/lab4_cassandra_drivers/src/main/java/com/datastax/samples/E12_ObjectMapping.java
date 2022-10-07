package com.datastax.samples;

import static com.datastax.samples.schema.SchemaUtils.createTableCommentByUser;
import static com.datastax.samples.schema.SchemaUtils.createTableCommentByVideo;
import static com.datastax.samples.schema.SchemaUtils.truncateTable;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.samples.objectmapping.Comment;
import com.datastax.samples.objectmapping.CommentByUser;
import com.datastax.samples.objectmapping.CommentByVideo;
import com.datastax.samples.objectmapping.CommentDao;
import com.datastax.samples.objectmapping.CommentDaoMapper;
import com.datastax.samples.schema.SchemaConstants;

public class E12_ObjectMapping implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E12_ObjectMapping.class);
   
    public static void main(String[] args) {
        try(CqlSession cqlSession = CqlSessionProvider.getInstance().getSession()) {
            
            // Create working table User (if needed)
            createTableCommentByUser(cqlSession);
            createTableCommentByVideo(cqlSession);
            
            // Comments are used in 2 queries, we need 2 tables to store it
            truncateTable(cqlSession, COMMENT_BY_USER_TABLENAME);
            truncateTable(cqlSession, COMMENT_BY_VIDEO_TABLENAME);
   
            // All logic is defined in Mapper/Dao/Entities in objectmapping package
            // Mapper required the table to exist
            CommentDao dao = CommentDaoMapper.builder(cqlSession)
                    .withDefaultKeyspace(KEYSPACE_NAME)
                    .build().commentDao();
            
            // DataSet
            UUID user_1    = UUID.randomUUID();UUID user_2    = UUID.randomUUID();
            UUID videoid_1 = UUID.randomUUID();UUID videoid_2 = UUID.randomUUID();
            Comment c1 = new Comment(user_1, videoid_1, "I am user1 and video1 is good");
            Comment c2 = new Comment(user_2, videoid_1, "I am user2 and video1 is bad");
            Comment c3 = new Comment(user_1, videoid_2, "Video2 is cool");
            Comment c4 = new Comment(user_2, videoid_2,  "Video2");
            
            /* ==================== CREATE =====================
             * Create comment (in 2 tables with BATCH)
             * ================================================= */
            dao.upsert(c1);dao.upsert(c2);
            dao.upsert(c3);dao.upsert(c4);
            dao.retrieveVideoComments(videoid_2).all()
               .stream().map(CommentByVideo::getComment)
               .forEach(LOGGER::info);
            
            /* =============== UPDATE ==========================
             * == Update one comment (in 2 tables with BATCH) ==
             * ================================================= */
            c1.setComment("This is my new comment");
            dao.upsert(c1);
            dao.retrieveVideoComments(videoid_1).all()
               .stream().map(CommentByVideo::getComment)
               .forEach(LOGGER::info);
            
            /* =============== DELETE ===========================
             * Delete one comment (in 2 tables with BATCH)     ==
             * Note that commentId is NOT ENOUGH as userid and ==
             * videoid are part of the the primary keys.       ==
             * ==================================================*/
            dao.delete(c1);
            dao.retrieveVideoComments(videoid_1).all()
               .stream().map(CommentByVideo::getComment)
               .forEach(LOGGER::info);
            
            /* 
             * ============================ READ ================================
             * == Query1: List comments for user_1 with table comment_by_user   =
             * == Query2: List comments for video_2 with table comment_by_video =
             * ==================================================================
             */
            
            dao.retrieveUserComments(videoid_2).all()
               .stream().map(CommentByUser::getComment)
               .forEach(LOGGER::info);
            
            dao.retrieveVideoComments(videoid_2).all()
               .stream().map(CommentByVideo::getComment)
               .forEach(LOGGER::info);
                        
        }
    }
    
}
