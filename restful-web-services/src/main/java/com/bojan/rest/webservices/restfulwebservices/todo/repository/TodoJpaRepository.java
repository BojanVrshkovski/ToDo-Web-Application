package com.bojan.rest.webservices.restfulwebservices.todo.repository;

import com.bojan.rest.webservices.restfulwebservices.todo.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo,Long> {
	List<Todo> findByUsername(String username);


}
