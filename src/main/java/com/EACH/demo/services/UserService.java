package com.EACH.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.EACH.demo.entities.User;
import com.EACH.demo.repositories.UserRepository;
import com.EACH.demo.services.exceptions.DatabaseException;
import com.EACH.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//call the methods of the repository and do exception handling with them

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//return a list of all the entities assigned to the data base
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//searches the id, if it's found it returns the entity assigned, else it throws a ResourceNotFoundException
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//saves a new entity in the data base
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//delete a entity of the data base depending on the id, if there is no entities that depend on this one, it is concluded
	//if there is other entity that depends on the one trying to delete, it throws a DatabaseException
	//if the id isn't found, it throws a ResourceNotFoundException
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//gets the id of a entity and a new object, update the object and saves it on the data base
			//if the id isn't found, it throws a ResourceNotFoundexception
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	//aux method that get the first entity, update the attributes needed and return the entity updated
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
