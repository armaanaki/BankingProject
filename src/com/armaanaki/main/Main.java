package com.armaanaki.main;

import com.armaanaki.banking.*;
import com.armaanaki.console.*;

public class Main {

	public static void main(String[] args) {
		//create a bank account with preset values, will be replaced with user entry and database soon
		BankAccount newAccount = ConsoleManager.createBankAccount();
		//display the information of the bank account
		System.out.println(newAccount.toString());
	}
	
}