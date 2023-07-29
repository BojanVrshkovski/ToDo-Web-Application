package com.bojan.rest.webservices.restfulwebservices.todo.service.impl;

import com.bojan.rest.webservices.restfulwebservices.todo.exceptions.InvalidIdException;
import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import com.bojan.rest.webservices.restfulwebservices.todo.model.request.TodoRequest;
import com.bojan.rest.webservices.restfulwebservices.todo.repository.TodoJpaRepository;
import com.bojan.rest.webservices.restfulwebservices.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

	private final TodoJpaRepository todoJpaRepository;

	@Autowired
	public TodoServiceImpl(TodoJpaRepository todoJpaRepository) {
		this.todoJpaRepository = todoJpaRepository;
	}

	@Override
	public List<Todo> readAllTodos() {
		return todoJpaRepository.findAll();
	}

	@Override
	public List<Todo> readAllTodosByUsername(String username) {
		return todoJpaRepository.findByUsername(username);
	}

	@Override
	public Todo readById(Long id) {
		return todoJpaRepository.findById(id).orElseThrow(InvalidIdException::new);
	}

	@Override
	public Todo create(TodoRequest todoRequest) {
		Todo todo = new Todo("bojan",todoRequest.getDescription(),todoRequest.getTargetDate(),false);

		return this.todoJpaRepository.save(todo);
	}

	@Override
	public Todo update(Long id, TodoRequest todoRequest) {
		Todo todo = readById(id);
		todo.setUsername("bojan");
		todo.setDescription(todoRequest.getDescription());
		todo.setTargetDate(todoRequest.getTargetDate());
		todo.setDone(false);

		return this.todoJpaRepository.save(todo);
	}

	@Override
	public Todo delete(Long id) {
		Todo todo = readById(id);
		this.todoJpaRepository.delete(todo);
		return todo;
	}
}
