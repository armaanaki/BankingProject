package com.armaanaki.main;

import com.armaanaki.banking.*;

public class Main {

	public static void main(String[] args) {
		//create a bank account with preset values, will be replaced with user entry and database soon
		BankAccount armaan = new BankAccount("Armaan", 1234567890, 500.00);
		//display the information of the bank account
		System.out.println(armaan.toString());
	}
	
}