package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.Category;

//annotation @Repository isn't mandatory
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
