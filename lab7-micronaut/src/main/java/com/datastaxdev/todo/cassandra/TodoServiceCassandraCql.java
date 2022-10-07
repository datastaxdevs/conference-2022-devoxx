package com.datastaxdev.todo.cassandra;

import static com.datastax.oss.driver.api.core.type.DataTypes.BOOLEAN;
import static com.datastax.oss.driver.api.core.type.DataTypes.TEXT;
import static com.datastax.oss.driver.api.core.type.DataTypes.TIMEUUID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.metadata.schema.ClusteringOrder;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastaxdev.TodoDto;
import com.datastaxdev.TodoService;
import com.datastaxdev.utils.ValidationUtils;

import jakarta.inject.Singleton;

/**
 * Implementation of the CRUD service with CORE CqlSession only.
 */
@Singleton
public class TodoServiceCassandraCql implements TodoService {
    
    /** Schema Constants. */
    public static final String TABLE_TODOITEMS   = "todoitems";
    public static final String TODO_USER_ID      = "user_id";
    public static final String TODO_ITEM_ID      = "item_id";
    public static final String TODO_TITLE        = "title";
    public static final String TODO_COMPLETED    = "completed";
    
    /** Build the statements. */
    private PreparedStatement psInsertTodo;
    private PreparedStatement psSelectTodo;
    private PreparedStatement psSelectUserTodo;
    private PreparedStatement psDeleteTodo;
    private PreparedStatement psDeleteUserTodo;

    /** Hold a reference to Cassandra connectivity. */
    private CqlSession cqlSession;

    /**
     * Constructor with CqlSession.
     *
     * @param cqlSession
     *      current cassandra Session
     */
    public TodoServiceCassandraCql(CqlSession cqlSession) {
        this.cqlSession = cqlSession;
        prepareStatements();
    }
    
    /**
     * Create table todoitems.
     * 
     * CREATE TABLE todoitems IF NOT EXISTS (
     *   user_id     text,
     *   item_id timeuuid,
     *   completed boolean,
     *   title text,
     *   PRIMARY KEY ((user_id), item_id)
     * ) WITH CLUSTERING ORDER BY (item_id ASC);
     * 
     * This method is static as we want to prepare statements in the constructor.
     * 
     * @param cqlSession
     *      cql Session
     */
    public static void createTableTodo(CqlSession cqlSession) {
        cqlSession.execute(SchemaBuilder.createTable(TABLE_TODOITEMS)
                        .ifNotExists()
                        .withPartitionKey(TODO_USER_ID, TEXT)
                        .withClusteringColumn(TODO_ITEM_ID, TIMEUUID)
                        .withColumn(TODO_COMPLETED, BOOLEAN)
                        .withColumn(TODO_TITLE, TEXT)
                        .withClusteringOrder(TODO_ITEM_ID, ClusteringOrder.ASC)
                        .build());
    }
    
    /** {@inheritDoc} */
    public TodoDto save(TodoDto todo) {
        if (todo.getItemId() == null) {
            todo.setItemId(Uuids.timeBased());
            cqlSession.execute(psInsertTodo.bind(
                    todo.getUserId(), 
                    todo.getItemId(), 
                    todo.getTitle(), 
                    todo.getCompleted()));
            return todo;
        }
        
        // Update by diff on not null fields to override value
        TodoDto toBeUpdated = findById(todo.getUserId(), todo.getItemId()).get();
        if (todo.getTitle() != null)     toBeUpdated.setTitle(todo.getTitle());
        if (todo.getCompleted() != null) toBeUpdated.setCompleted(todo.getCompleted());
        cqlSession.execute(psInsertTodo.bind(
                 toBeUpdated.getUserId(), 
                 toBeUpdated.getItemId(), 
                 toBeUpdated.getTitle(), 
                 toBeUpdated.getCompleted()));
        return toBeUpdated;
    }

    /** {@inheritDoc} */
    @Override
    public Optional<TodoDto> findById(String userId, UUID itemId) {
        ValidationUtils.assertNotEmpty(userId);
        ValidationUtils.assertNotNull(itemId);
        Row row = cqlSession.execute(psSelectTodo.bind(userId, itemId)).one();
        return (row != null) ? 
                Optional.ofNullable(mapRowAsTodo(row)) : 
                Optional.empty();
    }

    /** {@inheritDoc} */
    @Override
    public List<TodoDto> findByUser(String userId) {
        ValidationUtils.assertNotEmpty(userId);
        return cqlSession.execute(psSelectUserTodo.bind(userId))
                         .all().stream()
                         .map(this::mapRowAsTodo)
                         .collect(Collectors.toList());
    }

    /** {@inheritDoc} */
    @Override
    public void deleteById(String userId, UUID itemId) {
        ValidationUtils.assertNotEmpty(userId);
        ValidationUtils.assertNotNull(itemId);
        cqlSession.execute(psDeleteTodo.bind(userId, itemId));
    }

    /** {@inheritDoc} */
    @Override
    public void deleteByUser(String userId) {
        ValidationUtils.assertNotEmpty(userId);
        cqlSession.execute(psDeleteUserTodo.bind(userId));
    }

    /** {@inheritDoc} */
    @Override
    public void deleteAll() {
        cqlSession.execute(QueryBuilder.truncate(TABLE_TODOITEMS).build());
    }
    
    /**
     * Utility to build a bean from a row.
     * @param row
     *      current row
     * @return
     *      target bean
     */
    private TodoDto mapRowAsTodo(Row row) {
        TodoDto dto = new TodoDto();
        dto.setUserId(row.getString(TODO_USER_ID));
        dto.setItemId(row.getUuid(TODO_ITEM_ID));
        dto.setCompleted(row.getBoolean(TODO_COMPLETED));
        dto.setTitle(row.getString(TODO_TITLE));
        return dto;
    }

    /**
     * Prepared Once execute multiple times.
     */
    private void prepareStatements() {
        
        // INSERT INTO todo_items (user_id, item_id, title, completed,offset) VALUES(?,?,?,?,?)
        psInsertTodo = cqlSession.prepare(QueryBuilder
                .insertInto(TABLE_TODOITEMS)
                .value(TODO_USER_ID, QueryBuilder.bindMarker())
                .value(TODO_ITEM_ID, QueryBuilder.bindMarker())
                .value(TODO_TITLE, QueryBuilder.bindMarker())
                .value(TODO_COMPLETED, QueryBuilder.bindMarker())
                .build());
        
        // SELECT * FROM todo_items where user_id=?
        psSelectUserTodo = cqlSession.prepare(QueryBuilder
                .selectFrom(TABLE_TODOITEMS).all()
                .whereColumn(TODO_USER_ID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
        // SELECT * FROM todo_items where user_id=? and item_id=?
        psSelectTodo = cqlSession.prepare(QueryBuilder
                .selectFrom(TABLE_TODOITEMS).all()
                .whereColumn(TODO_USER_ID).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(TODO_ITEM_ID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
        // DELETE FROM todo_items where user_id=?
        psDeleteUserTodo = cqlSession.prepare(QueryBuilder
                .deleteFrom(TABLE_TODOITEMS)
                .whereColumn(TODO_USER_ID).isEqualTo(QueryBuilder.bindMarker())
                .build());
        
        // DELETE FROM todo_items where user_id=? and item_id=?
        psDeleteTodo = cqlSession.prepare(QueryBuilder
                .deleteFrom(TABLE_TODOITEMS)
                .whereColumn(TODO_USER_ID).isEqualTo(QueryBuilder.bindMarker())
                .whereColumn(TODO_ITEM_ID).isEqualTo(QueryBuilder.bindMarker())
                .build());
    }        

}
