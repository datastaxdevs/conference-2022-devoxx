package com.datastaxdev.todo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastaxdev.TodoDto;
import com.datastaxdev.TodoService;
import com.datastaxdev.todo.cassandra.TodoServiceCassandraCql;
import com.datastaxdev.todo.web.Todo;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.context.ServerRequestContext;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

@Validated
@Controller("/api/v1")
public class TodoRestController {
    
    /** CqlSession initialized from application.yaml */
    @Inject
    private CqlSession cqlSession;
    
    /** Todo service reference. */
    private TodoService repo;
    
    @Get(value = "/{user}/todos/")
    public List<Todo> findAllByUser(
            @PathVariable(value = "user") @NotEmpty  String user) {
        return getTodoService().findByUser(user)
                   .stream()
                   .map(this::fromDto)
                   .map(t -> populateUrlWithId(t, ServerRequestContext.currentRequest().get()))
                   .collect(Collectors.toList());
    }

    @Get("/{user}/todos/{uid}")
    public HttpResponse<Todo> findById(
            @PathVariable(value = "user") @NotEmpty String user,
            @PathVariable(value = "uid")  @NotEmpty String itemId) {
        Optional<TodoDto> e = getTodoService().findById(user, UUID.fromString(itemId));
        if (e.isEmpty()) return HttpResponse.notFound();
        Todo todo = fromDto(e.get());
        populateUrl(todo, ServerRequestContext.currentRequest().get());
        //LOGGER.info("Find user={}, TODO={}", user, todo);
        return HttpResponse.ok(todo);
    }

    @Post("/{user}/todos/")
    public HttpResponse<Todo> create(
            @PathVariable(value = "user") String user,
            @Body @NotNull Todo todoReq) throws URISyntaxException {
        TodoDto te = toDto(todoReq, user);
        te = getTodoService().save(te);
        todoReq.setUuid(te.getItemId());
        populateUrlWithId(todoReq, ServerRequestContext.currentRequest().get());
        //LOGGER.info("Created user={}, TODO={}", user, todoReq);
        return HttpResponse.created(new URI(todoReq.getUrl())).body(todoReq);
    }

    @Patch("/{user}/todos/{uid}")
    public HttpResponse<Todo> update(
            @PathVariable(value = "user")  @NotEmpty String user,
            @PathVariable(value = "uid") @NotEmpty  String itemId,
            @Body @NotNull Todo todo)
    throws URISyntaxException {
        //LOGGER.info("Updating user={} id={} with TODO {}", user, itemId, todo);
        Optional<TodoDto> e = getTodoService().findById(user, UUID.fromString(itemId));
        if (e.isEmpty()) return HttpResponse.notFound();
        todo.setUuid(UUID.fromString(itemId));
        TodoDto todoDto = toDto(todo, user);
        todoDto = getTodoService().save(todoDto);
        populateUrl(todo, ServerRequestContext.currentRequest().get());
        return HttpResponse.ok(todo);
    }
    
    @Delete("/{user}/todos/{uid}")
    public HttpResponse<Void> deleteById(
            @PathVariable(value = "user") String user,
            @PathVariable(value = "uid")  String uid) {
        //LOGGER.info("Delete TODO id={} for user={}", uid, user);
        if (getTodoService().findById(user, UUID.fromString(uid)).isEmpty()) {
            return HttpResponse.notFound();
        }
        getTodoService().deleteById(user, UUID.fromString(uid));
        return HttpResponse.noContent();
    }
    
    @Delete("/{user}/todos/")
    public HttpResponse<Void> deleteAllByUser(@PathVariable(value = "user") String user) {
        getTodoService().deleteByUser(user);
        return HttpResponse.noContent();
    }
    
    /**
     * Access todo service.
     *
     * @return
     *      todo services
     */
    public TodoService getTodoService() {
        if (repo == null) {
            repo = new TodoServiceCassandraCql(cqlSession);
        }
        return repo;
    }

    private Todo fromDto(TodoDto te) {
        Todo todo = new Todo();
        todo.setTitle(te.getTitle());
        todo.setUuid(te.getItemId());
        todo.setCompleted(te.getCompleted());
        return todo;
    }
    
    private TodoDto toDto(Todo te, String user) {
        TodoDto dto = new TodoDto();
        dto.setUserId(user);
        dto.setItemId(te.getUuid());
        dto.setTitle(te.getTitle());
        dto.setCompleted(te.isCompleted());
        return dto;
    }

    private Todo populateUrlWithId(Todo t, HttpRequest<Object> req) {
        String fullUrl = new StringBuilder("http://")
                .append(req.getServerAddress().getHostName())
                .append(":")
                .append(req.getServerAddress().getPort())
                .append(UriBuilder.of(req.getUri()).path(t.getUuid().toString()))
                .toString();
        if (fullUrl.contains("gitpod")) {
            fullUrl.replaceAll("http://", "https://");
        }
        t.setUrl(fullUrl);
        return t;
    }

    private Todo populateUrl(Todo t, HttpRequest<Object> req) {
        String fullUrl = new StringBuilder("http://")
                .append(req.getServerAddress().getHostName())
                .append(":")
                .append(req.getServerAddress().getPort())
                .append(UriBuilder.of(req.getUri()))
                .toString();
        if (fullUrl.contains("gitpod")) {
            fullUrl.replaceAll("http://", "https://");
        }
        t.setUrl(fullUrl);
        return t;
    }
}