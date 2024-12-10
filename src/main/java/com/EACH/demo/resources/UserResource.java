package com.EACH.demo.resources;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 7ea4cb110a064938eacfac478746336235ad1fa3
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EACH.demo.entities.User;
<<<<<<< HEAD
=======
import com.EACH.demo.services.UserService;
>>>>>>> 7ea4cb110a064938eacfac478746336235ad1fa3

@RestController
@RequestMapping(value = "/users")
public class UserResource {
<<<<<<< HEAD
	@GetMapping
	//rest controller that return /users
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "99999", "12345");
		return ResponseEntity.ok().body(u);
=======
	
	@Autowired
	private UserService service;
	@GetMapping
	//rest controller that return to /users
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
>>>>>>> 7ea4cb110a064938eacfac478746336235ad1fa3
	}
}
