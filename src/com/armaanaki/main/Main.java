package com.armaanaki.main;

import com.armaanaki.console.*;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i<5; i++){
		//create a bank account with preset values, will be replaced with user entry and database soon
		ConsoleManager.createBankAccount();
		}
		for(int i = 0; i<5; i++){
			System.out.println(ConsoleManager.userAccounts[i].toString());
		}
	}	
}