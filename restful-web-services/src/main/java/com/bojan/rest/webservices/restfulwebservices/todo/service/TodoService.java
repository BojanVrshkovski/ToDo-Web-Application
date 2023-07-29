package com.bojan.rest.webservices.restfulwebservices.todo.service;

import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import com.bojan.rest.webservices.restfulwebservices.todo.model.request.TodoRequest;

import java.util.List;

public interface TodoService {
	List<Todo> readAllTodos();
	List<Todo> readAllTodosByUsername(String username);
	Todo readById(Long id);
	Todo create(TodoRequest todoRequest);
	Todo update(Long id,TodoRequest todoRequest);
	Todo delete(Long id);
}
