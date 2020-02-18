package com.revature.org;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8237765671428953678L;
	/**
	 * 
	 */
	private String make;
	private String model;
	Price msrp;
	Price chosenOffer;
	HashMap<User, Price> offers;
	ArrayList<User> usersMadeOffers;
	
	public Car(String make, String model) {
		setName(make, model);
		setMSRP(msrp);
		usersMadeOffers = new ArrayList<User>();
	}
	
	private void setMSRP(Price msrp2) {
		// TODO Auto-generated method stub
		
	}

	public Price getMSRP() {
		return msrp;
	}
	protected void addOffer(User user, Price price) {
		offers.put(user, price);
		usersMadeOffers.add(user);
	}

	public String getMake() {
		return make;
	}

	public void setName(String make, String model) {
		this.make = make;
		this.model = model;
	}

	public String getModel() {
		// TODO Auto-generated method stub
		return model;
	}
}
