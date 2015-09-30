package com.armaanaki.console;

import java.util.Scanner;

import com.armaanaki.banking.BankAccount;

public class ConsoleManager {
	private static String invalidInput = "Invalid Input, please try again.";
	private static Scanner userInput = new Scanner(System.in);
	
	//used to make a BankAccount from another class
	public static BankAccount createBankAccount(){
		BankAccount newAccount = new BankAccount(accountHolder(), accountNumber(), accountTotal());
			return newAccount;
	}
	
	//asks for account holder's name and verifies it is indeed filled out
	private static String accountHolder(){
		System.out.println("Please enter the account holder's name.");
		String accountHolder = userInput.nextLine();
		while(accountHolder.isEmpty()){
			System.out.println(invalidInput);
			accountHolder=userInput.nextLine();
		}
		return accountHolder;
	}
	
	//asks for the account number and checks to see if it is indeed a number
	private static int accountNumber(){
		System.out.println("Please enter your account number.");
		int accountNumber = 0;
		while(accountNumber == 0){
			if(userInput.hasNextInt()) accountNumber = userInput.nextInt();
			else{
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return accountNumber;
	}
	
	//asks for total amount in the bank account and validates it as a number
	private static double accountTotal(){
		System.out.println("Please enter the total amount in the account.");
		double accountTotal = 0;
		while(accountTotal == 0){
			if(userInput.hasNextDouble()) accountTotal = userInput.nextDouble();
			else{
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return accountTotal;
	}
}
