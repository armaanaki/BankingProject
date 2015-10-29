package com.armaanaki.banking;

public class CheckingsAccount extends BankAccount {
	
	final private double overdraftFee = 10;
	
	final private double maxOverdraft = 200;
	
	private double totalOverdraft;

	private boolean overdraft;
	
	public CheckingsAccount(String accountHolderName, int accountNumber, double accountBalance, String accountPassword, boolean overdraft) {
		setAccountHolderName(accountHolderName);
		setAccountBalance(accountBalance);
		setAccountPassword(accountPassword);
		setAccountNumber(accountNumber);
		setAccountType("checkings");
		this.overdraft = overdraft;
		if(overdraft){
			totalOverdraft = maxOverdraft;
		} else {
			totalOverdraft = 0;
		}
	}

	public void deposit(double deposit) {
		setAccountBalance(getAccountBalance() + deposit);
	}

	public void withdraw(double withdraw) {
		setAccountBalance(getAccountBalance() - withdraw);
		if(getAccountBalance()<0){
			setAccountBalance(getAccountBalance() - overdraftFee);
		}
	}
	
	public void setTotalOverdraft(double totalOverdraft) {
		this.totalOverdraft = totalOverdraft;
	}
	
	public double getTotalOverdraft() {
		return totalOverdraft;
	}
	
	public void setOverdraft(boolean overdraft) {
		this.overdraft = overdraft;
	}
	
	public boolean getOverdraft() {
		return overdraft;
	}
}
