package com.revature.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.org.*;
//import com.revature.util.*;

public class DealerSystem {
	
	static Scanner in;
	boolean go;
	static String input;
	public static HashMap<String, User> usernames;
	public static HashMap<User, String> passwords;
	public static HashMap<User, Boolean> active;
	Lot lot;
	ArrayList<Offer> offers;
	

	public static void main(String[] args) {
		DealerSystem system = new DealerSystem();
	}
	
	public DealerSystem() {
		in = new Scanner(System.in);
		go = true;
		input = null;
		lot = new Lot();
		usernames = new HashMap<String, User>();
		passwords = new HashMap<User, String>();
		active = new HashMap<User, Boolean>();
		offers = new ArrayList<Offer>();
		addUser(new Employee(), "TheBest", "password"); // User type, username, password
		go();
	}
	
	private void addUser(User user, String username, String password) {
		usernames.put(username, user);
		passwords.put(user, password);
		active.put(user, false);
	}

	public void go() {
		while(go) {
			final int CUSTOMER = 1;
			final int EMPLOYEE = 2;
			final int EXIT = 0;
			System.out.print("Input 1 for Customer menu, 2 for employee menu, "
					+ "or, at any time, 0 for the main menu: ");
			input = in.nextLine();
			switch(Integer.parseInt(input)) {
			case EXIT:
				go = false;
				break;
			case CUSTOMER:
				customerMenu();
				break;
			case EMPLOYEE:
				employeeMenu();
				
			}
		}
		System.out.println("Goodbye!!!");
	}

	private void employeeMenu() {
		System.out.println("Employee menu");
		boolean go = true;
		boolean loggedIn = false;
		User emp = null;
		while(go) {
			if(!loggedIn) {
				emp = login(UserType.EMPLOYEE);
			}
			boolean validInput = false;
			while(!validInput) {
				System.out.println("Here are the following options:");
				System.out.print("1 to manage lot inventory, 2 to manage offers, 3 to"
						+ " view payments, \nand as always, 0 to logout and exit the system: ");
				input = in.nextLine();
				if(Integer.parseInt(input) == 0 | Integer.parseInt(input) == 1 
						| Integer.parseInt(input) == 2) validInput = true;
			}
			if(Integer.parseInt(input) == 0) {
				active.put(emp, false);
				go = false;
			}
			if(Integer.parseInt(input) == 1) manageInventory();
			if(Integer.parseInt(input) == 2) manageOffers();
			if(Integer.parseInt(input) == 3) viewPayments();
		}
		System.out.println("Back");
	}

	private void viewPayments() {
		// TODO Auto-generated method stub
		
	}

	private void manageOffers() {
		while(true) {
			System.out.print("Manage offers: "); System.out.println("Input 1 to accept, 2 to reject, or 3 for next offer: ");
			input = in.nextLine();
			int currentOffer = 0;
			if(Integer.parseInt(input) == 0) {
				System.out.println("Back");
				break;
			}
			if(Integer.parseInt(input) == 1) acceptOffer(currentOffer);
			if(Integer.parseInt(input) == 2) rejectOffer(currentOffer);
			if(Integer.parseInt(input) == 3) {
				currentOffer = nextOffer(currentOffer);
				System.out.println("Current offer: "  + offers.get(currentOffer).getAmount());
			}
		}
	}

	private int nextOffer(int currentOffer) {
		if(!(currentOffer < offers.size()))
		return currentOffer ++;
		else return currentOffer = 0;
	}

	private void rejectOffer(int currentOffer) {
		// TODO Auto-generated method stub
		
	}

	private void acceptOffer(int currentOffer) {
		
	}

	private void manageInventory() {
		while(true) {
			System.out.print("Input 1 to view inventory 2 to add a car to the lot, or 3 to remove: ");
			input = in.nextLine();
			if(Integer.parseInt(input) == 0) break;
			if(Integer.parseInt(input) == 1) viewInv();
			if(Integer.parseInt(input) == 2) addCar();
			if(Integer.parseInt(input) == 3) removeCar();
		}
	}

	private void viewInv() {
		if(!lot.isEmpty()) {
			for(Lot.Entry<Car, Price> car : lot.entrySet()) {
				System.out.println(car.getKey().getMake() + " " + car.getKey().getModel() + " $" + car.getValue().getAmount());
			}
			System.out.println();
		} else System.out.println("Lot empty!");
	}

	private void removeCar() {
		boolean go = true;
		while(go) {
			System.out.print("Input make and model of car separated by a space: ");
			input = in.nextLine();
			String[] name = input.split(" ");
			for(Lot.Entry<Car, Price> car : lot.entrySet()) {
				if(car.getKey().getMake().equals(name[0]) || car.getKey().getModel().equals(name[1])); {
					lot.remove(car.getKey());
					go = false;
				}
			}
		}
	}

	private void addCar() {
		System.out.print("Input make: ");
		String make = in.nextLine();
		System.out.print("Model: ");
		String model = in.nextLine();
		Car car = new Car(make, model);
		System.out.print("MSRP: $");
		Price msrp = new Price(Integer.parseInt(in.nextLine()));
		lot.put(car, msrp);
	}

	public static User login(UserType type) {
		boolean loggedIn = false;
		String username = null;
		while(!loggedIn) {
			if(type == UserType.EMPLOYEE) {
				loggedIn = Employee.login(in);
			}
			if(type == UserType.CUSTOMER) {
				loggedIn = Customer.login(in);
			}
		}
		return usernames.get(username);
	}

	private void customerMenu() {
		System.out.println("Customer menu");
		User user = null;
		while(go) {
			login(UserType.CUSTOMER);
			System.out.print("Input 1 to view cars, 2 to make an offer, 3 to view owned cars, "
					+ "4 to view remaining payments, or 5 to create a customer account: ");
			input = in.nextLine();
			if(Integer.parseInt(input) == 0) {
				go = false;
			}
			if(Integer.parseInt(input) == 1) viewInv();
			if(Integer.parseInt(input) == 2) makeOffer((Customer)user);
			if(Integer.parseInt(input) == 3) viewOwned((Customer)user);
		}
		
	}

	private void viewOwned(Customer user) {
		user.getOwned();
	}

	private void makeOffer(Customer user) {
		// TODO Auto-generated method stub
		
	}
}
