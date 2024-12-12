package com.EACH.demo.entities.enums;

//Enum of the status of an Order

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	//Constructor
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//getter method
	public int getCode() {
		return code;
	}
	
	//checks what order status it is depending on the code of the parameter, throwing an exception in case the code is invalid
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
