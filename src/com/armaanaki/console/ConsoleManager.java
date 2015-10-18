package com.armaanaki.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.armaanaki.banking.*;

public class ConsoleManager {
	
	//repeated invalid input message
	private static final String invalidInput = "Invalid Input, please try again.";
	
	//Scanner to take input from console
	private static final Scanner userInput = new Scanner(System.in);
		
	//bank account used to gain access to totalAccounts variable
	private static final BankAccount referenceAccount = new ReferenceAccount();
	
	//map that stores all the BankAccounts and passwords
	private static Map<String, BankAccount> userAccounts = new HashMap<String, BankAccount>();
	
	//first stage to select a new account or existing one
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
	
	//allows the user to choose a pre-existing BankAccount, will fail if there are not enough accounts available
	private static void chooseAccount(){
		if(referenceAccount.getTotalAccounts() > 0) {
			System.out.println("Please enter your account number.");
			accountChoices(validateBankAccount());
		} else {
			System.out.println("No bank accounts available!");
		}
	}
	
	//asks for user input to validate a BankAccount, they must input a correct account number/account password combination
	private static BankAccount validateBankAccount(){
		int accountNumber = 0;
		String accountPassword;
		while(true){
			System.out.println("The account number is...");
			if(userInput.hasNextInt()){
				accountNumber = userInput.nextInt();
			}
			if(userAccounts.containsKey(Integer.toString(accountNumber))){
				System.out.println("Please enter your account password.");
				accountPassword = userInput.next();
				BankAccount userAccount = userAccounts.get(Integer.toString(accountNumber));
				if(userAccount.getAccountPassword().equals(accountPassword)){
					return userAccount;
				} else {
					System.out.println(invalidInput);
				}
			} else {
				System.out.println(invalidInput);
			}
		}
	}
	
	//gives the user options for the bank account they selected
	public static void accountChoices(BankAccount userAccount){
		while(true) {
			System.out.println("Good evening " + userAccount.getAccountHolderName() + "! Here are your options: \n 1. View account information. \n "
					+ "2. Make a transfer. \n 3. Make a deposit. \n 4. Make a withdrawl. \n 5. Change account holder name. \n "
					+ "6. Change account password. \n 7. Return to main menu.");
			String input = userInput.next();
			
			switch(input){
				case "1": 
					System.out.println(userAccount.toString());
					break;
			
				case "2": 
					if(referenceAccount.getTotalAccounts()>1 && userAccount.getAccountBalance()>0){
						System.out.println("What account would you like to tranfer to?");
						BankAccount transferAccount = validateBankAccount();
						System.out.println("How much would you like to transfer?");
						double transferTotal;
						if(userAccount.getAccountType().equals("savings")){
							transferTotal = userInputDouble(userAccount.getAccountBalance());
						} else {
							transferTotal = userInputDouble(userAccount.getAccountBalance() + ((CheckingsAccount) userAccount).getTotalOverdraft());
						}
						transferAccount.deposit(transferTotal);
						userAccount.withdraw(transferTotal);
						successfulTransaction(userAccount);
					} else {
						System.out.println("Not enough accounts to make a transfer!");
					}
					break;
				
				case "3": 
					userAccount.deposit(deposit());
					successfulTransaction(userAccount);
					break;
				
				case "4": 
					if(userAccount.getAccountType().equals("savings")){
						userAccount.withdraw(withdraw(userAccount.getAccountBalance()));
						successfulTransaction(userAccount);
					} else {
						if(userAccount.getAccountBalance() + ((CheckingsAccount) userAccount).getTotalOverdraft()>0){
							userAccount.withdraw(withdraw(userAccount.getAccountBalance() + ((CheckingsAccount) userAccount).getTotalOverdraft()));
							successfulTransaction(userAccount);
						} else {
							System.out.println("Not enough funds!");
						}
					}
					break;
				case "5": 
					userAccount.setAccountHolderName(inputAccountHolder());
					break;
				
				case "6" :
					userAccount.setAccountPassword(inputAccountPassword());
					break;
					
				case "7" : 
					return;
					
				default: System.out.println(invalidInput);
					break;
			}
		}
	}
	
	//used to make a BankAccount from another class
	private static void createBankAccount(){
		System.out.println("What account would you like to create?");
		while(true){
			System.out.println("Type \"C\" for Checkings \nType \"S\" for Savings \nType \"E\" to exit.");
			String input = userInput.next();
			input.toUpperCase();
			switch(input){
				case "C":
					createCheckingsAccount();
					return;
					
				case "S":
					createSavingsAccount();
					return;
					
				case "E":
					return;
					
				default:
					System.out.println(invalidInput);
					break;
			}
		}
	}
	
	//creates a SavingsAccount from user input
	private static void createSavingsAccount(){
		BankAccount user = new SavingsAccount(inputAccountHolder(), inputAccountTotal(), inputAccountPassword());
		userAccounts.put(Integer.toString(user.getAccountNumber()), user);
		System.out.println("Congratulations " + user.getAccountHolderName() + "\nYour account number is: " + user.getAccountNumber()
		+ "\nYour account password is: " + user.getAccountPassword());
	}
	
	//creates a CheckingsAccount from user input
	private static void createCheckingsAccount(){
		BankAccount user = new CheckingsAccount(inputAccountHolder(), inputAccountTotal(), inputAccountPassword(), inputOverdraft());
		userAccounts.put(Integer.toString(user.getAccountNumber()), user);
		System.out.println("Congratulations " + user.getAccountHolderName() + "\nYour account number is: " + user.getAccountNumber()
		+ "\nYour account password is: " + user.getAccountPassword());
	}
	
	//asks if the user would like overdraft protection
	private static boolean inputOverdraft(){
		while(true){
			System.out.println("Would you like overdraft protection credit? Y/N");
			String input = userInput.next();
			input.toUpperCase();
			switch(input){
				case "Y":
					return true;
					
				case "N":
					return false;
					
				default:
					System.out.println(invalidInput);
					break;
			}
		}
	}
	
	//asks for account holder's name and verifies it is indeed filled out
	private static String inputAccountHolder(){
		System.out.println("Please enter the account holder's name.");
		return createValidString();
	}
	
	//allows the user to input an account password, also validates the user's input
	private static String inputAccountPassword(){
		String password;
		while(true){
			System.out.println("Please enter the account password.");
			password = createValidString();
			System.out.println("Please re-enter your password.");
			if(password.equals(createValidString())){
				break;
			} else {
				System.out.println(invalidInput);
			}
		}
		return password;
	}
	
	//create a valid, non-empty string
	private static String createValidString(){
		String input = userInput.next();
		while(input.isEmpty()){
			System.out.println(invalidInput);
			input=userInput.next();
		}
		return input;
	}
	
	//asks for balance in the bank account
	private static double inputAccountTotal(){
		System.out.println("Please enter the total amount in the account.");
		return userInputDouble(Double.POSITIVE_INFINITY);
	}
	
	//asks for amount wished to deposit
	private static double deposit(){
		System.out.println("Please enter the total amount you wish to deposit.");
		return userInputDouble(Double.POSITIVE_INFINITY);
	}
	
	//asks for amount wished to withdraw
	private static double withdraw(double max){
		System.out.println("Please enter the total amount you wish to withdraw.");
		return userInputDouble(max);
	}
	
	//creates a valid double, used for deposits, withdrawals, and setting account balance
	private static double userInputDouble(double max){
		double input =0;
		while(input<0.01 || input>max){
			if(userInput.hasNextDouble()){
				input = userInput.nextDouble();
				if(input<0.01 || input>max){
					System.out.println(invalidInput);
				}
			} else {
				System.out.println(invalidInput);
				userInput.next();
			}
		}
		return input;
	}
	
	//notifies the user of a successful transaction and the balance of the account after it
	private static void successfulTransaction(BankAccount userAccount){
		if (userAccount.getAccountType().equals("savings")){
			System.out.println(String.format("Your transaction was a success! Your new balance is: $%,.2f \nYour total interest is: $%,.2f", userAccount.getAccountBalance(), ((SavingsAccount) userAccount).getTotalInterest()));
		} else {
			System.out.println(String.format("Your transaction was a success! Your new balance is: $%,.2f", userAccount.getAccountBalance()));
		}
	}
}