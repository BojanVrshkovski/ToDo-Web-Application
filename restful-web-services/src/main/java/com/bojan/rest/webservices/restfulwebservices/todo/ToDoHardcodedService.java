package com.bojan.rest.webservices.restfulwebservices.todo;

import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoHardcodedService {
	private static List<Todo> todos = new ArrayList<>();
	private static Long idCounter = 0L;

	static {
		todos.add(new Todo(++idCounter,"bojan","Learn to dance",new Date(),false));
		todos.add(new Todo(++idCounter,"bojan","Learn about Microservices",new Date(),false));
		todos.add(new Todo(++idCounter,"bojan","Learn about Angular",new Date(),false));
		todos.add(new Todo(++idCounter,"bojan","Learn about Angular",new Date(),false));
		todos.add(new Todo(++idCounter,"bojan","Learn about Java",new Date(),false));
		todos.add(new Todo(++idCounter,"bojan","Learn about Spring Boot",new Date(),false));

	}

	public Todo save(Todo todo){
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	public List<Todo> findAll(){
		return todos;
	}

	public Todo deleteById(Long id){
		Todo todo = findById(id);
		if(todo == null){
			return null;
		}
		if (todos.remove(todo)){
			return todo;
		}
		return null;
	}

	public Todo findById(Long id) {
		for(Todo todo:todos){
			if(todo.getId() == id){
				return todo;
			}
		}
		return null;
	}

}
