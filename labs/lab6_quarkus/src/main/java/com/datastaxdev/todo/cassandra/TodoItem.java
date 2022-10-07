package com.datastaxdev.todo.cassandra;

import static com.datastaxdev.todo.cassandra.TodoServiceCassandraCql.TABLE_TODOITEMS;
import static com.datastaxdev.todo.cassandra.TodoServiceCassandraCql.TODO_COMPLETED;
import static com.datastaxdev.todo.cassandra.TodoServiceCassandraCql.TODO_ITEM_ID;
import static com.datastaxdev.todo.cassandra.TodoServiceCassandraCql.TODO_TITLE;
import static com.datastaxdev.todo.cassandra.TodoServiceCassandraCql.TODO_USER_ID;

import java.util.UUID;

import com.datastax.oss.driver.api.mapper.annotations.ClusteringColumn;
import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

@Entity
@CqlName(TABLE_TODOITEMS)
public class TodoItem {
    
    @PartitionKey
    @CqlName(TODO_USER_ID)
    private String userId;
    
    @ClusteringColumn
    @CqlName(TODO_ITEM_ID)
    private UUID itemId;
    
    @CqlName(TODO_TITLE)
    private String title;
    
    @CqlName(TODO_COMPLETED)
    private Boolean completed;
   
    /**
     * Getter accessor for attribute 'userId'.
     *
     * @return
     *       current value of 'userId'
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter accessor for attribute 'userId'.
     * @param userId
     * 		new value for 'userId '
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter accessor for attribute 'itemId'.
     *
     * @return
     *       current value of 'itemId'
     */
    public UUID getItemId() {
        return itemId;
    }

    /**
     * Setter accessor for attribute 'itemId'.
     * @param itemId
     * 		new value for 'itemId '
     */
    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    /**
     * Getter accessor for attribute 'title'.
     *
     * @return
     *       current value of 'title'
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter accessor for attribute 'title'.
     * @param title
     * 		new value for 'title '
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter accessor for attribute 'completed'.
     *
     * @return
     *       current value of 'completed'
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     * Setter accessor for attribute 'completed'.
     * @param completed
     * 		new value for 'completed '
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
