package com.datastaxdev;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Definition of services to work with the Todo Application.
 *
 * @author Cedrick Lunven (@clunven)
 */
public interface TodoService {
    
    /**
     * Save Todoitems.
     *
     * @param todo
     *      list of todos
     * @return
     *      updated todo with if if relevant
     */
    TodoDto save(TodoDto todo);
    
    /**
     * Retrieve an task by its itentifier.
     *
     * @param userId
     *      userId
     * @param itemId
     *      itemId
     * @return
     *      if the Task exists
     */
    Optional<TodoDto> findById(String userId, UUID itemId);
    
    /**
     * Retrieve the list of Tasks for a user (if exist).
     * 
     * @param userId
     *      user identifier
     * @return
     *      list of Tasks for the user
     */
    List<TodoDto> findByUser(String userId);
    
    /**
     * Delete a task from its identifier
     * 
     * @param userId
     *          user identifer
     * @param itemId
     *          item identifier
     */
     void deleteById(String userId, UUID itemId);
     
     /**
      * Delete all tasks for a user.
      *
      * @param userId
      *      user identifier
      */
     void deleteByUser(String userId);
     
     /**
      * Clean DB.
      */
     void deleteAll();

}
