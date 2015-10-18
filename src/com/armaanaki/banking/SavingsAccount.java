package com.armaanaki.banking;

public class SavingsAccount extends BankAccount{
	
	private double totalInterest;
	
	public SavingsAccount(String accountHolderName, double accountBalance, String accountPassword){
		createdNewAccount();
		setAccountHolderName(accountHolderName);
		setAccountBalance(accountBalance);
		setAccountPassword(accountPassword);
		setAccountNumber(getTotalAccounts());
		setAccountType("savings");
	}

	public void deposit(double deposit) {
		double interest = deposit * .001;
		totalInterest += interest;
		setAccountBalance(getAccountBalance() + deposit + interest);
	}

	public void withdraw(double withdraw) {
		setAccountBalance(getAccountBalance() - withdraw);
	}

	public double getTotalInterest(){
		return totalInterest;
	}
	
	public void setTotalInterest(double totalInterest){
		this.totalInterest = totalInterest;
	}
}