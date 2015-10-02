package com.armaanaki.console;

import java.util.Scanner;

import com.armaanaki.banking.BankAccount;

public class ConsoleManager {
	//repeated invalid input message
	private static String invalidInput = "Invalid Input, please try again.";
	//Scanner to take input from console
	private static Scanner userInput = new Scanner(System.in);
	
	public static BankAccount[] userAccounts = new BankAccount[100];
	
	//used to make a BankAccount from another class
	public static void createBankAccount(){
			BankAccount newAccount = new BankAccount();
			userAccounts[newAccount.getTotalAccounts()] = new BankAccount(inputAccountHolder(), inputAccountTotal());
	}
	
	//asks for account holder's name and verifies it is indeed filled out
	private static String inputAccountHolder(){
		System.out.println("Please enter the account holder's name.");
		String accountHolder = userInput.next();
		while(accountHolder.isEmpty()){
			System.out.println(invalidInput);
			accountHolder=userInput.next();
		}
		return accountHolder;
	}
	
	/* CURRENTLY NOT IN USE
	//asks for the account number and checks to see if it is less than 10 digits and not negative
	private static int inputAccountNumber(){
		System.out.println("Please enter your account number.");
		int accountNumber = 0;
		while(accountNumber <= 0 || accountNumber >= 1000000000){
			if(userInput.hasNextInt()){
				accountNumber = userInput.nextInt();
				if(accountNumber <= 0 || accountNumber >= 1000000000) System.out.println(invalidInput);
			}
			else{
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return accountNumber;
	}
	*/
	
	//asks for balance in the bank account
	private static double inputAccountTotal(){
		System.out.println("Please enter the total amount in the account.");
		return userInputDouble();
	}
	
	//asks for amount wished to deposit
	public  static double deposit(){
		System.out.println("Please enter the total amount you wish to deposit.");
		return userInputDouble();
	}
	
	//asks for amount wished to withdraw
	public static double withdraw(){
		System.out.println("Please enter the total amount you with to withdraw.");
		return userInputDouble();
	}
	
	//creates a valid double, used for deposits, withdrawals, and setting account balance
	private static double userInputDouble(){
		double input =0;
		while(input<0.01){
			if(userInput.hasNextDouble()){
				input = userInput.nextDouble();
				if(input<0.01) System.out.println(invalidInput);
			}
			else{
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return input;
	}
}