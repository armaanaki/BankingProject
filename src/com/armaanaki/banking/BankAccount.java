package com.armaanaki.banking;

public class BankAccount {

	private int BankAccountNumber;
	private String BankAccountHolderName;
	private double BankAccountAmount;
	
	public int getBankAccountNumber() {
		return BankAccountNumber;
	}

	public void setBankAccountNumber(int bankAccountNumber) {
		this.BankAccountNumber = bankAccountNumber;
	}

	public String getBankAccountHolderName(){
		return BankAccountHolderName;
	}
	
	public void setBankAccountHolderName(String bankAccountHolderName){
		this.BankAccountHolderName = bankAccountHolderName;
	}
	
	public double getBankAccountAmount(){
		return BankAccountAmount;
	}
	
	public void setBankAccountAmmount(double bankAccountAmount){
		this.BankAccountAmount = bankAccountAmount;
	}
}
