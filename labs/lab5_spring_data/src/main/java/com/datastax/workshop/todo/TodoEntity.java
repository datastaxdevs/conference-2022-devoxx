package com.datastax.workshop.todo;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table(value = TodoEntity.TABLENAME)
public class TodoEntity {
    
    public static final String TABLENAME        = "todos";
    public static final String COLUMN_UID       = "uid";
    public static final String COLUMN_TITLE     = "title";
    public static final String COLUMN_COMPLETED = "completed";
    public static final String COLUMN_ORDER     = "offset";
    
    @PrimaryKey
    @Column(COLUMN_UID)
    @CassandraType(type = Name.UUID)
    private UUID uid;
    
    @Column(COLUMN_TITLE)
    @CassandraType(type = Name.TEXT)
    private String title;
    
    @Column(COLUMN_COMPLETED)
    @CassandraType(type = Name.BOOLEAN)
    private boolean completed = false;
    
    @Column(COLUMN_ORDER)
    @CassandraType(type = Name.INT)
    private int order = 0;
    
    
    public TodoEntity() {}
    
    public TodoEntity(UUID uid, String title, boolean completed, int order) {
        super();
        this.uid = uid;
        this.title = title;
        this.completed = completed;
        this.order = order;
    }

    public TodoEntity(String title, int offset) {
        this(UUID.randomUUID(), title, false, offset);
    }
    
    

    /**
     * Getter accessor for attribute 'uid'.
     *
     * @return
     *       current value of 'uid'
     */
    public UUID getUid() {
        return uid;
    }

    /**
     * Setter accessor for attribute 'uid'.
     * @param uid
     * 		new value for 'uid '
     */
    public void setUid(UUID uid) {
        this.uid = uid;
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
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Setter accessor for attribute 'completed'.
     * @param completed
     * 		new value for 'completed '
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Getter accessor for attribute 'order'.
     *
     * @return
     *       current value of 'order'
     */
    public int getOrder() {
        return order;
    }

    /**
     * Setter accessor for attribute 'order'.
     * @param order
     * 		new value for 'order '
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "+ TodoEntity [uid=" + uid + ", title=" + title + ", completed=" + completed + ", order=" + order + "]";
    }

}
