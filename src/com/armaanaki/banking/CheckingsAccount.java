package com.armaanaki.banking;

public class CheckingsAccount extends BankAccount{
	
	final private double overdraftFee = 10;
	
	final private double maxOverdraft = 200;
	
	private double totalOverdraft;
	
	public CheckingsAccount(String accountHolderName, double accountBalance, String accountPassword, boolean overdraft){
		createdNewAccount();
		setAccountHolderName(accountHolderName);
		setAccountBalance(accountBalance);
		setAccountPassword(accountPassword);
		setAccountNumber(getTotalAccounts());
		setAccountType("checkings");
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
	
	public void setTotalOverdraft(double totalOverdraft){
		this.totalOverdraft = totalOverdraft;
	}
	
	public double getTotalOverdraft(){
		return totalOverdraft;
	}
}
