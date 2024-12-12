package com.EACH.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.EACH.demo.entities.Category;
import com.EACH.demo.repositories.CategoryRepository;
import com.EACH.demo.services.exceptions.DatabaseException;
import com.EACH.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;


//call the methods of the repository and do exception handling with them
@Service
public class CategoryServices {
	
	@Autowired
	private CategoryRepository repository;
	
	//return a list of all the entities assigned to the data base
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//searches the id, if it's found it returns the entity assigned, else it throws a ResourceNotFoundException
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//saves a new entity in the data base
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	
	//delete a entity of the data base depending on the id, if there is no entities that depend on this one, it is concluded
	//if there is other entity that depends on the one trying to delete, it throws a DatabaseException
	//if the id isn't found, it throws a ResourceNotFoundException
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//gets the id of a entity and a new object, update the object and saves it on the data base
	//if the id isn't found, it throws a ResourceNotFoundexception
	public Category update(Long id, Category obj) {
		try {
		Category entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	//aux method that get the first entity, update the attributes needed and return the entity updated
	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
	}
}
