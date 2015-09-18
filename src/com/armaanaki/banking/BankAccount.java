package com.armaanaki.banking;

public class BankAccount{
	String holderName = "";
	int number = 0;
	double amount = 0.00;
	
	BankAccount(String accountHolderName, int accountNumber, double accountAmount){
		holderName = accountHolderName;
		number = accountNumber;
		amount = accountAmount;
	}
	public static void showAccountInformation(String accountHolderName, int accountNumber, double accountAmount){
		BankAccount userAccount = new BankAccount(accountHolderName, accountNumber, accountAmount);
		System.out.println(userAccount.number + "::" + userAccount.holderName + " currently has a balance of $" + userAccount.amount);
	}
}