package com.EACH.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.EACH.demo.entities.Order;
import com.EACH.demo.services.OrderServices;

//Takes the methods of the OrderServices and apply them so it works on PostMan and others

//RestConstroller that add the /orders to the link of the application
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderServices service;
	
	//find methods search the entity in the data base
	@GetMapping
	//return response 202 with the list of all the entities assigned to the data base once /orders is searched
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//return a response depending the id (202 in case the id exists) is passes and the entity assigned to that id in the data base
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//maps the method insert
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//maps the method delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//doesn't have the update method because once an order it's done it can't be changed, only cancelled
	
}
