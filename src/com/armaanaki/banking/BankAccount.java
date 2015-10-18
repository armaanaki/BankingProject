package com.armaanaki.banking;

public abstract class BankAccount {
	
	//the unique number that identifies the account
	private int accountNumber;
	
	//name of the account holder
	private String accountHolderName;
	
	//the total amount (in dollars) located in the user's account
	private double accountBalance;
	
	//the account's password
	private String accountPassword;
	
	//the account type
	private String accountType;
	
	//the total accounts made
	private static int totalAccounts = 0;
	
	/*//fall-back constructor in case variables aren't assigned
	public BankAccount(){
		createBankAccount("", 0, 0.00, "");
	}
	
	//main constructor used to define a bank account, includes the variables called earlier
	public BankAccount(String accountHolderName, double accountBalance, String accountPassword){
		BankAccount.totalAccounts++;
		createBankAccount(accountHolderName, BankAccount.totalAccounts, accountBalance, accountPassword);
	}
	
	//sets the bank account variables. Can be replaced with setters, matter of preference(?)
	private void createBankAccount(final String accountHolderName, final int accountNumber, final double accountBalance, final String accountPassword){
		this.accountHolderName = accountHolderName;
		this.accountNumber = BankAccount.totalAccounts;
		this.accountBalance = accountBalance;
		this.accountPassword = accountPassword;
	}*/
	
	protected void createdNewAccount(){
		totalAccounts++;
	}
	
	//adds money to the account based on amount deposited
	public abstract void deposit(double deposit);/*{
		this.accountBalance+=deposit;
	}*/
	
	//removes money from the account based on amount withdrawn
	public abstract void withdraw(double withdraw);/*{
		//this.accountBalance-=withdraw;
	}*/
	
	//method to print all account information
	public String toString(){
		return String.format("%09d::%s's %s currently has a balance of $%,.2f", accountNumber, accountHolderName, accountType, accountBalance);
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
	
	public double getAccountBalance(){
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance){
		this.accountBalance = accountBalance;
	}
	
	public int getTotalAccounts(){
		return totalAccounts;
	}
	
	public void setTotalAccounts(int totalAccounts){
		BankAccount.totalAccounts=totalAccounts;
	}
	
	public String getAccountPassword(){
		return accountPassword;
	}
	
	public void setAccountPassword(String accountPassword){
		this.accountPassword = accountPassword;
	}
	
	public String getAccountType(){
		return accountType;
	}
	
	public void setAccountType(String accountType){
		this.accountType=accountType;
	}
}