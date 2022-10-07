package com.datastaxdev.todo.cassandra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.datastax.oss.driver.api.mapper.annotations.Query;
import com.datastaxdev.todo.TodoDto;
import com.datastaxdev.todo.TodoService;

/**
 * Implementation of the service with ObjectMapping.
 *
 * @author Cedrick LUNVEN (@clunven)
 */
@ApplicationScoped
public class TodoServicesCassandraOM implements TodoService {

    /** Driver Dao. */
    private TodoItemDao todoDao;
    
    /**
     * Constructor with parameters.
     * 
     * @param cqlSession
     *      current cqlSession
     */
    public TodoServicesCassandraOM(CqlSession cqlSession) {
        todoDao = TodoItemMapper
                .builder(cqlSession)
                .withDefaultKeyspace(cqlSession.getKeyspace().get())
                .build()
                .todoItemDao();
    }
    
    @Override
    public TodoDto save(TodoDto todo) {
        if(null == todo.getItemId()) todo.setItemId(Uuids.timeBased());
        todoDao.save(fromDtoToEntity(todo));
        return todo;
    }

    @Override
    public Optional<TodoDto> findById(String userId, UUID itemId) {
        return todoDao.findById(userId, itemId).map(this::fromEntityToDto);
    }

    @Override
    public List<TodoDto> findByUser(String userId) {
        return todoDao.findByUser(userId)
                      .all().stream()
                      .map(this::fromEntityToDto)
                      .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String userId, UUID itemId) {
        todoDao.deleteById(userId, itemId);
    }

    @Override
    public void deleteByUser(String userId) {
        todoDao.deleteByUser(userId);
    }

    @Override
    @Query("truncate todoitems")
    public void deleteAll() {}
    
    private TodoItem fromDtoToEntity(TodoDto todo) {
        TodoItem ti = new TodoItem();
        ti.setCompleted(todo.getCompleted());
        ti.setItemId(todo.getItemId());
        ti.setTitle(todo.getTitle());
        ti.setUserId(todo.getUserId());
        return ti;
    }
    
    private TodoDto fromEntityToDto(TodoItem ti) {
        TodoDto dto = new TodoDto();
        dto.setCompleted(ti.getCompleted());
        dto.setItemId(ti.getItemId());
        dto.setTitle(ti.getTitle());
        dto.setUserId(ti.getUserId());
        return dto;
    }
}
