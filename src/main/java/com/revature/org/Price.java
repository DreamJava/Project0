package com.revature.org;

public class Price {
	
	private int value;
	
	public Price(int value){
		setValue(value);
	}
	
	private void setValue(int value) {
		this.value = value;
	}

	public int getAmount() {
		return value;
	}
}
