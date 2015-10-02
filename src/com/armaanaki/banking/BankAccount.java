package com.armaanaki.banking;

public class BankAccount {
	
	//the unique number that identifies the account
	private int accountNumber;
	
	//name of the account holder
	private String accountHolderName;
	
	//the total amount (in dollars) located in the user's account
	private double accountBalance;
	
	//the total accounts made
	private static int totalAccounts = 0;
	
	//fall-back constructor in case variables aren't assigned
	public BankAccount(){
		createBankAccount("", 0, 0.00);
	}
	
	//main constructor used to define a bank account, includes the variables called earlier
	public BankAccount(String accountHolderName, double accountBalance){
		BankAccount.totalAccounts++;
		createBankAccount(accountHolderName, BankAccount.totalAccounts, accountBalance);
	}
	
	//sets the bank account variables. Can be replaced with setters, matter of preference(?)
	private void createBankAccount(final String accountHolderName, final int accountNumber, final double accountBalance){
		this.accountHolderName = accountHolderName;
		this.accountNumber = BankAccount.totalAccounts;
		this.accountBalance = accountBalance;
	}
	
	//adds money to the account based on amount deposited
	public void deposit(double deposit){
		this.accountBalance+=deposit;
	}
	
	//removes money from the account based on amount withdrawn
	public void withdraw(double withdraw){
		this.accountBalance-=withdraw;
	}
	//method to print all account information
	public String toString(){
		return String.format("%09d::%s currently has a balance of $%.2f", accountNumber, accountHolderName, accountBalance);
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
	
	public double getaccountBalance(){
		return accountBalance;
	}
	
	public void setBankaccountBalance(double accountBalance){
		this.accountBalance = accountBalance;
	}
	
	public int getTotalAccounts(){
		return totalAccounts;
	}
	
	public void setTotalAccounts(int totalAccounts){
		BankAccount.totalAccounts=totalAccounts;
	}
	
}