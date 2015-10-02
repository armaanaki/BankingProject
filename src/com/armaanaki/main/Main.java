package com.armaanaki.main;

import com.armaanaki.banking.*;
import com.armaanaki.console.*;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i<5; i++){
		//create a bank account with preset values, will be replaced with user entry and database soon
		BankAccount newAccount = ConsoleManager.createBankAccount();
		//display the information of the bank account
		System.out.println(newAccount.toString());
		newAccount.deposit(ConsoleManager.deposit());
		System.out.println(newAccount.toString());
		newAccount.withdraw(ConsoleManager.withdraw());
		System.out.println(newAccount.toString());
		}
	}	
}