package com.datastaxdev.todo;

import java.util.UUID;

public class TodoDto {

    private String  userId;
    private UUID    itemId;
    private String  title;
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
