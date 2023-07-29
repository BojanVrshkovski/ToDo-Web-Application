/*package com.bojan.rest.webservices.restfulwebservices.todo;

import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import com.bojan.rest.webservices.restfulwebservices.todo.repository.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoJPAResource {
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUsername(username);
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable Long id){
		return todoJpaRepository.findById(id).get();
	}
//	@DeleteMapping("/jpa/users/{username}/todos/{id}")
//	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id){
//		Todo todo = todoJpaRepository.deleteById(id);
//		if(todo!=null){
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
//	}
//
//	@PutMapping("/jpa/users/{username}/todos/{id}")
//	public ResponseEntity<Todo> updateTodo(@PathVariable String username,
//	                                       @PathVariable Long id,
//	                                       @RequestBody Todo todo){
//		Todo todoUpdated = todoJpaRepository.save(todo);
//
//		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
//	}
//
//	@PostMapping("/jpa/users/{username}/todos")
//	public ResponseEntity<Void> createTodo(@PathVariable String username,
//	                                       @RequestBody Todo todo){
//		Todo todoCreated = todoJpaRepository.save(todo);
//
//		//Location
//		//Get current resource URL
//		URI uri = ServletUriComponentsBuilder.
//			fromCurrentRequest().path("/{id}").
//			buildAndExpand(todoCreated.getId()).toUri();
//
//		return ResponseEntity.created(uri).build();
//	}
}*/
