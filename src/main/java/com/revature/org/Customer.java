package com.revature.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.util.*;

public class Customer implements User {
	
	List<Car> owned;
	
	protected Customer() {
		owned = new ArrayList<Car>();
		owned.add(new Car("Nissan", "Kicks"));
	}

	public static boolean login(Scanner in) {
		DealerSystem.login(UserType.CUSTOMER);
		return true;
	}

	public void regCustAcct() {
		// TODO Auto-generated method stub
		
	}
	
	public void makeOffer(Car car, Price price) {
		
	}

	public ArrayList<Car> getOwned() {
		return (ArrayList<Car>) owned;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String input, Scanner in) {
		// TODO Auto-generated method stub
		
	}
	
}
