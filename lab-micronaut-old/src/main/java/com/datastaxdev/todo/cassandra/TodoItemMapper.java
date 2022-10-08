package com.datastaxdev.todo.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface TodoItemMapper {
    
    @DaoFactory
    TodoItemDao todoItemDao();
    
    /**
     * Utility to initialize.
     * 
     * @param session
     *      target session
     * @return
     *      target builder
     */
    static MapperBuilder<TodoItemMapper> builder(CqlSession session) {
        return new TodoItemMapperBuilder(session);
    }
    
}