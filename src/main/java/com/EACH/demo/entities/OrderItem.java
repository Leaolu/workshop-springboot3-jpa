package com.EACH.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.EACH.demo.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Entity with id, OrderItem primary key as id, price and quantity

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Double price;
	private Integer quantity;
	
	//return the multiplication of price and quantity
	public Double getSubTotal() {
		return price * quantity;
	}
	
	//Constructors
	public OrderItem() {
	}

	public OrderItem(Order order, Product product,Integer quantity, Double price) {
		this.price = price;
		this.quantity = quantity;
		id.setOrder(order);
		id.setProduct(product);
	}
	
	//getters and setters methods
	//JsonIgnore so the Order doesn't print an infinite loop when it's called
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	public void setProduct(Product order) {
		id.setProduct(order);
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	//hashCode and equals using just the id to tell OrderItems apart
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
