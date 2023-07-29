package com.bojan.rest.webservices.restfulwebservices.todo.controller;

import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import com.bojan.rest.webservices.restfulwebservices.todo.model.request.TodoRequest;
import com.bojan.rest.webservices.restfulwebservices.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoController {
	@Autowired
	private TodoService todoService;
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodosByUserName(@PathVariable String username){
		return todoService.readAllTodosByUsername(username);
	}

	@GetMapping("/todos")
	public List<Todo> getAllTodos(){
		return todoService.readAllTodos();
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable Long id){
		return todoService.readById(id);
	}
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id){
		Todo todo = todoService.delete(id);
		if(todo!=null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,
	                                       @PathVariable Long id,
	                                       @RequestBody TodoRequest todo){
		Todo todoUpdated = todoService.update(id,todo);

		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username,
	                                       @RequestBody TodoRequest todo){
		//todo.setUsername(username);
		Todo todoCreated = todoService.create(todo);

		//Location
		//Get current resource URL
		URI uri = ServletUriComponentsBuilder.
			fromCurrentRequest().path("/{id}").
			buildAndExpand(todoCreated.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
