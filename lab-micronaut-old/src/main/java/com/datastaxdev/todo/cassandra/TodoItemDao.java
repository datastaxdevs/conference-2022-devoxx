package com.datastaxdev.todo.cassandra;

import java.util.Optional;
import java.util.UUID;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.DefaultNullSavingStrategy;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.entity.saving.NullSavingStrategy;

@Dao
@DefaultNullSavingStrategy(NullSavingStrategy.SET_TO_NULL)
public interface TodoItemDao {
    
    @Delete(entityClass = TodoItem.class)
    void deleteByUser(String userId);
    
    @Delete(entityClass = TodoItem.class)
    void deleteById(String userId, UUID itemId);
    
    @Select
    PagingIterable<TodoItem> findByUser(String userId);

    @Select
    Optional<TodoItem> findById(String userId, UUID itemId);
    
    @Insert
    void save(TodoItem product);    
}
