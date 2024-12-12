package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.Order;

//Repository of Order to use the functions of the JpaRepository in this class

//annotation @Repository isn't mandatory
public interface OrderRepository extends JpaRepository<Order, Long>{

}
