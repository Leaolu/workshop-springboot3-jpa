package com.EACH.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EACH.demo.entities.OrderItem;
import com.EACH.demo.entities.pk.OrderItemPK;

//Repository of OrderItem to use the functions of the JpaRepository in this class

//annotation @Repository isn't mandatory
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}