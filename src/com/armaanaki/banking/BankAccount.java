package com.armaanaki.banking;

public class BankAccount {
	
	private int accountNumber;
	private String accountHolderName;
	private double accountTotal;
	
	public BankAccount(){
		createBankAccount("", 0, 0.00);
	}
	
	public BankAccount(String accountHolderName, int accountNumber, double accountTotal){
		createBankAccount(accountHolderName, accountNumber, accountTotal);
	}
	
	private void createBankAccount(final String accountHolderName, final int accountNumber, final double accountTotal){
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.accountTotal = accountTotal;
	}
	
	public String toString(){
		return accountNumber + "::" + accountHolderName + " currently has a balance of $" + accountTotal;
	}
	
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
