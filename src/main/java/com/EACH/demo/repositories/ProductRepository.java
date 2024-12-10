package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.Product;

//annotation @Repository isn't mandatory
public interface ProductRepository extends JpaRepository<Product, Long>{

}
