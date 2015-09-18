package com.armaanaki.bankinginformation;

public class BankAccountInformation {
	
	private int number = 0;
	private String holderName = "";
	private double amount = 0.0;
	
	public int getAccountNumber() {
		return number;
	}

	public void setAccountNumber(int accountNumber) {
		number = accountNumber;
	}

	public String getAccountHolderName(){
		return holderName;
	}
	
	public void setAccountHolderName(String accountHolderName){
		holderName = accountHolderName;
	}
	
	public double getAccountAmount(){
		return amount;
	}
	
	public void setBankAccountAmmount(double accountAmount){
		amount = accountAmount;
	}
	
}
