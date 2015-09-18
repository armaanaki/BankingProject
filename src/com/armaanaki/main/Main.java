package com.armaanaki.main;

import com.armaanaki.banking.*;

public class Main {

	public static void main(String[] args) {
		BankAccount armaan = new BankAccount("Armaan", 1234567890, 500.00);
		System.out.println(armaan.toString());
	}
	
}