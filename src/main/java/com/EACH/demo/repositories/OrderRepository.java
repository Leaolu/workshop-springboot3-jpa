package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.Order;

//annotation @Repository isn't mandatory
public interface OrderRepository extends JpaRepository<Order, Long>{

}
