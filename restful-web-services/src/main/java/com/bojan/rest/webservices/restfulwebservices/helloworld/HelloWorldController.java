package com.bojan.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	//GET
	//URI - /hello-world
	//method - "Hello World"
	@GetMapping("/hello-world")
	public String helloWorld(){
		return "Hello World";
	}

	//hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBeaan(){
		//throw new RuntimeException("Some error has happened");
		return new HelloWorldBean("Hello World - Changed");
	}

	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVaariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World %s",name));
	}
}
