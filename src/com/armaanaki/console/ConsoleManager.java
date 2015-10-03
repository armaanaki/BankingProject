package com.armaanaki.console;

import java.util.Scanner;

import com.armaanaki.banking.BankAccount;

public class ConsoleManager {
	//repeated invalid input message
	private static final String invalidInput = "Invalid Input, please try again.";
	//Scanner to take input from console
	private static final Scanner userInput = new Scanner(System.in);
		
	//bank account used to gain access to totalAccounts variable
	private static final BankAccount refrenceAccount = new BankAccount();
	
	//array used to store bank accounts
	public static BankAccount[] userAccounts = new BankAccount[100];
	
	//first stage to select
	public static void introSelection(){
		while(true){
			System.out.println("Welcome! Please input a value: \n 1. Select a pre-existing bank account. "
					+ "\n 2. Establish a new account. \n 3. Exit");
			String choice = userInput.next();
			switch(choice){
				case "1": 
					chooseAccount();
					break;
				case "2": 
					createBankAccount();
					break;
				case "3": 
					System.out.println("Thank you for using Lizardman and Co. Banking! Have a nice day!");
					System.exit(0);
				default: 
					System.out.println(invalidInput + "\n");
					break;
			}
		}
	}
	
	private static void chooseAccount(){
		if(refrenceAccount.getTotalAccounts() > 0) {
			System.out.println("Please enter your account number.");
			accountChoices(validateBankAccount());
		} else {
			System.out.println("No bank accounts available!");
		}
	}
	
	private static BankAccount validateBankAccount(){
		int accountNumber = 0;
		while(true){
			if(userInput.hasNextInt()){
				accountNumber = userInput.nextInt();
			}
			if(accountNumber>0 && accountNumber<=refrenceAccount.getTotalAccounts()){
				return userAccounts[accountNumber-1];
			} else { 
				System.out.println(invalidInput);
			}
		}
	}
	
	public static void accountChoices(BankAccount userAccount){
		while(true) {
			System.out.println("Good evening " + userAccount.getAccountHolderName() + "! Here are your options: \n 1. View account information. \n "
					+ "2. Make a transfer. \n 3. Make a deposit. \n 4. Make a withdrawl. \n 5. Change account holder name. \n 6. Return to main menu.");
			String input = userInput.next();
			
			switch(input){
				case "1": 
					System.out.println(userAccount.toString());
					break;
			
				case "2": 
					System.out.println("What account would you like to tranfer to?");
					BankAccount transferAccount = validateBankAccount();
					System.out.println("How much would you like to transfer?");
					double transferTotal = userInputDouble();
					transferAccount.deposit(transferTotal);
					userAccount.withdraw(transferTotal);
					successfulTransaction(userAccount);
					break;
				
				case "3": 
					userAccount.deposit(deposit());
					successfulTransaction(userAccount);
					break;
				
				case "4": 
					userAccount.withdraw(withdraw());
					successfulTransaction(userAccount);
					break;
				
				case "5": 
					userAccount.setAccountHolderName(inputAccountHolder());
					break;
				
				case "6" : 
					return;
					
				default: System.out.println(invalidInput);
					break;
			}
		}
	}
	
	//used to make a BankAccount from another class
	private static void createBankAccount(){
			userAccounts[refrenceAccount.getTotalAccounts()] = new BankAccount(inputAccountHolder(), inputAccountTotal());
			System.out.println("Congratulations " + userAccounts[refrenceAccount.getTotalAccounts() - 1].getAccountHolderName() 
					+ " your account number is: " + userAccounts[refrenceAccount.getTotalAccounts() - 1].getAccountNumber());
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
	
	//asks for balance in the bank account
	private static double inputAccountTotal(){
		System.out.println("Please enter the total amount in the account.");
		return userInputDouble();
	}
	
	//asks for amount wished to deposit
	private static double deposit(){
		System.out.println("Please enter the total amount you wish to deposit.");
		return userInputDouble();
	}
	
	//asks for amount wished to withdraw
	private static double withdraw(){
		System.out.println("Please enter the total amount you with to withdraw.");
		return userInputDouble();
	}
	
	//creates a valid double, used for deposits, withdrawals, and setting account balance
	private static double userInputDouble(){
		double input =0;
		while(input<0.01){
			if(userInput.hasNextDouble()){
				input = userInput.nextDouble();
				if(input<0.01){
					System.out.println(invalidInput);
				}
			} else {
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return input;
	}
	
	private static void successfulTransaction(BankAccount userAccount){
		System.out.println(String.format("Your transaction was a success! Your new balance is: $%,.2f", userAccount.getaccountBalance()));
	}
}