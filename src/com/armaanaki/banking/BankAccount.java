package com.armaanaki.banking;

public class BankAccount {
	
	//the unique number that identifies the account
	private int accountNumber;
	
	//name of the account holder
	private String accountHolderName;
	
	//the total amount (in dollars) located in the user's account
	private double accountTotal;
	
	//fall-back constructor in case variables aren't assigned
	public BankAccount(){
		createBankAccount("", 0, 0.00);
	}
	
	
	//main constructor used to define a bank account, includes the variables called earlier
	public BankAccount(String accountHolderName, int accountNumber, double accountTotal){
		createBankAccount(accountHolderName, accountNumber, accountTotal);
	}
	
	//sets the bank account variables. Can be replaced with setters, matter of preferance(?)
	private void createBankAccount(final String accountHolderName, final int accountNumber, final double accountTotal){
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.accountTotal = accountTotal;
	}
	
	//method to print all account information
	public void displayAccountInformation(){
		System.out.printf("%010d::%s currently has a balance of $%.2f", accountNumber, accountHolderName, accountTotal);
	}
	
	//getters and setters for BankAccount variables
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName(){
		return accountHolderName;
	}
	
	public void setAccountHolderName(String accountHolderName){
		this.accountHolderName = accountHolderName;
	}
	
	public double getAccountTotal(){
		return accountTotal;
	}
	
	public void setBankAccountTotal(double accountTotal){
		this.accountTotal = accountTotal;
	}
	
}
