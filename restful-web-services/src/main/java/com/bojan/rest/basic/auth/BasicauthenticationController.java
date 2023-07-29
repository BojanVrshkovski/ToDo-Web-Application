package com.bojan.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicauthenticationController {

	@GetMapping("/basicauth")
	public AuthenticationBean helloWorldBean(){
		//throw new RuntimeException("Some error has happened");
		return new AuthenticationBean("You are authenticated");
	}
}
