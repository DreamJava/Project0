package com.revature.org;

import java.util.Scanner;

import com.revature.org.User;
import com.revature.util.DealerSystem;

public class Employee implements User {

	public static boolean login(Scanner in) {
		
		System.out.print("Please login.\nInput your username: ");
		String input = in.nextLine();
		if(input.isEmpty()) System.out.println("Invalid input");
		else if(DealerSystem.usernames.containsKey(input)) {
			String username = input;
			boolean loggedIn = false;
			while(!loggedIn) {
				System.out.print("Input your password, " + username + ": ");
				input = in.nextLine();
				if(input.equals(DealerSystem.passwords.get(DealerSystem.usernames.get(username)))) {
					DealerSystem.active.put(DealerSystem.usernames.get(username), true);
					loggedIn = true;
				}
			}
		}
		return true;
	}

	public void regCustAcct() {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(String input, Scanner in) {
		// TODO Auto-generated method stub
		
	}

}
