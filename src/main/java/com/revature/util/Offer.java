package com.revature.util;

import com.revature.org.*;

public class Offer extends Price{
	
	Customer cust;
	Car car;

	Offer(Customer cust, Car car, Price price){
		super(price.getAmount());
		this.cust = cust;
		this.car = car;
	}
}
