package com.datastax.samples.objectmapping;

import java.util.UUID;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.samples.schema.SchemaConstants;

/**
 * Specialization for USER.
 *
 * @author DataStax Developer Advocates team.
 */
@Entity
@CqlName(SchemaConstants.COMMENT_BY_USER_TABLENAME)
public class CommentByUser extends Comment {
    
    /** Serial. */
    private static final long serialVersionUID = 1453554109222565840L;
     
    /**
     * Default constructor.
     */
    public CommentByUser() {}
    
    /**
     * Copy constructor.
     *
     * @param c
     */
    public CommentByUser(Comment c) {
        this.commentid  = c.getCommentid();
        this.userid     = c.getUserid();
        this.videoid    = c.getVideoid();
        this.comment    = c.getComment();
    }

    /**
     * Getter for attribute 'userid'.
     *
     * @return
     *       current value of 'userid'
     */
    @PartitionKey
    public UUID getUserid() {
        return userid;
    }

}
