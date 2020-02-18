package com.revature.org;

import java.io.Serializable;
import java.util.Scanner;

public interface User extends Serializable{

	public void login(String input, Scanner in);
	
	public void regCustAcct();
	
}
