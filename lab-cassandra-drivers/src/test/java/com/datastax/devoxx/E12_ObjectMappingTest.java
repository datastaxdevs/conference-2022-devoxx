package com.datastax.devoxx;

import static com.datastax.devoxx.schema.SchemaUtils.createTableCommentByUser;
import static com.datastax.devoxx.schema.SchemaUtils.createTableCommentByVideo;
import static com.datastax.devoxx.schema.SchemaUtils.truncateTable;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.devoxx.objectmapping.Comment;
import com.datastax.devoxx.objectmapping.CommentByUser;
import com.datastax.devoxx.objectmapping.CommentByVideo;
import com.datastax.devoxx.objectmapping.CommentDao;
import com.datastax.devoxx.objectmapping.CommentDaoMapper;
import com.datastax.devoxx.schema.SchemaConstants;
import com.datastax.oss.driver.api.core.CqlSession;

/**
 * !! WARNING Tests with no Assertions here (I assume) !!
 * 
 * @author cedricklunven
 */
@TestMethodOrder(OrderAnnotation.class)
public class E12_ObjectMappingTest implements SchemaConstants {
    
    private static Logger LOGGER = LoggerFactory.getLogger(E12_ObjectMappingTest.class);
    
    // DataSet
    private static UUID user_1    = UUID.randomUUID();
    private static UUID user_2    = UUID.randomUUID();
    private static UUID videoid_1 = UUID.randomUUID();
    private static UUID videoid_2 = UUID.randomUUID();
    private static Comment c1 = new Comment(user_1, videoid_1, "I am user1 and video1 is good");
    private static Comment c2 = new Comment(user_2, videoid_1, "I am user2 and video1 is bad");
    private static Comment c3 = new Comment(user_1, videoid_2, "Video2 is cool");
    private static Comment c4 = new Comment(user_2, videoid_2,  "Video2");
    
    @BeforeAll
    public static void shout_init_statements() {
        try(CqlSession cqlSession = CqlSession.builder().build()) {
            
            // Create working table User (if needed)
            createTableCommentByUser(cqlSession);
            createTableCommentByVideo(cqlSession);
            
            // Comments are used in 2 queries, we need 2 tables to store it
            truncateTable(cqlSession, COMMENT_BY_USER_TABLENAME);
            truncateTable(cqlSession, COMMENT_BY_VIDEO_TABLENAME);
        }
    }
    
    @Test
    @Order(1)
    public void should_insert() {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
    		CommentDao dao = CommentDaoMapper.builder(cqlSession)
                     .withDefaultKeyspace(cqlSession.getKeyspace().get())
                     .build().commentDao();
    		 
            dao.upsert(c1);dao.upsert(c2);
            dao.upsert(c3);dao.upsert(c4);
            dao.retrieveVideoComments(videoid_2).all()
               .stream().map(CommentByVideo::getComment)
               .forEach(LOGGER::info);
    	}
    }       
       
    @Test
    @Order(2)
    public void should_delete() {
    	try(CqlSession cqlSession = CqlSession.builder().build()) {
    		c1.setComment("This is my new comment");
    		CommentDao dao = CommentDaoMapper.builder(cqlSession)
                    .withDefaultKeyspace(cqlSession.getKeyspace().get())
                    .build().commentDao();
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
