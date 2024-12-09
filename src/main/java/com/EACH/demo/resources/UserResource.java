package com.EACH.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EACH.demo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	//rest controller that return /users
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "99999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
