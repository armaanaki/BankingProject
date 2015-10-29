package com.armaanaki.banking;

//creates a reference account used to retrieve the total BankAccounts made
public class ReferenceAccount extends BankAccount {
	
	public ReferenceAccount(){
		setAccountHolderName("");
		setAccountBalance(0);
		setAccountPassword("");
		setAccountNumber(0);
		setAccountType("Reference Account");
	}

	public void deposit(double deposit) {	
	}

	public void withdraw(double withdraw) {
	}
	
}
