package com.armaanaki.console;

import java.sql.*;

public class BankAccountDAO {
	
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql593476";
	
	private final String USER = "sql593476";
	
	private final String PASS = "mL2*tK9*";
	
	private final String connectingMessage = "Establishing connection to database.";
	
	private final String creatingSQLCommandMessage = "Creating SQL command.";
	
	private final String communicatingWithDBMessage = "Communicating with the database.";
	
	private final String closingMessage = "Closing connection to database.";
	
	private Connection bankAccountDB;
	
	private Statement bankAccountDBStatement;
	
	private String sql;
	
	private ResultSet accountInfo;
	
	public BankAccountDAO() {
			try {
				Class.forName(JDBC_DRIVER).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public void addAccount(String accountHolder, int accountNumber, double accountBalance, String accountType, String accountPassword, 
			boolean overdraft, double totalInterest) {
		try {
			//System.out.println(connectingMessage);
			bankAccountDB = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println(creatingSQLCommandMessage);
			sql = String.format("INSERT INTO BankAccounts VALUES ('%s', %d, %f, '%s', '%s', 0, %d, %f);", 
					accountHolder, accountNumber, accountBalance, accountType, accountPassword, overdraft ? 1 : 0, totalInterest);
			bankAccountDBStatement = bankAccountDB.createStatement();
			//System.out.println(communicatingWithDBMessage);
			bankAccountDBStatement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			//System.out.println(closingMessage);
				if (bankAccountDBStatement != null) {
					bankAccountDBStatement.close();
				}
			} catch (SQLException se){
			}
			try {
				if (bankAccountDB != null) {
					bankAccountDB.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}
	
	public void updateAccount(String accountHolder, int accountNumber, double accountBalance, String accountType, String accountPasswordHash, 
			boolean overdraft, double totalInterest, int totalAccounts) {
		try {
			//System.out.println(connectingMessage);
			bankAccountDB = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println(creatingSQLCommandMessage);
			sql = String.format("UPDATE BankAccounts SET accountHolder='%s', accountNumber=%d, accountBalance=%f, accountType='%s',"
					+ " accountPassword='%s', totalAccounts=0, overdraft=%d, totalInterest=%f WHERE accountNumber=%d;", accountHolder, accountNumber, accountBalance, 
					accountType, accountPasswordHash, overdraft ? 1 : 0, totalInterest, accountNumber);
			bankAccountDBStatement = bankAccountDB.createStatement();
			//System.out.println(communicatingWithDBMessage);
			bankAccountDBStatement.executeUpdate(sql);
			sql = String.format("UPDATE BankAccounts SET totalAccounts=%d WHERE accountNumber=0", totalAccounts);
			bankAccountDBStatement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//System.out.println(closingMessage);
				if (bankAccountDBStatement != null) {
					bankAccountDBStatement.close();
				}
			} catch (SQLException se){
			}
			try {
				if (bankAccountDB != null) {
					bankAccountDB.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}
	
	
	
	public double getAccountBalance(int accountNumber, String accountPassword) {
		return getNumberInfo(accountNumber, accountPassword, "accountBalance");
	}
	
	public double getTotalInterest(int accountNumber, String accountPassword) {
		return getNumberInfo(accountNumber, accountPassword, "totalInterest");
	}
	
	public String getAccountHolderName(int accountNumber, String accountPassword) {
		return getStringInfo(accountNumber, accountPassword, "accountHolder");
	}
	
	public String getAccountType(int accountNumber, String accountPassword) {
		return getStringInfo(accountNumber, accountPassword, "accountHolder");
	}
	
	public boolean getOverdraft(int accountNumber, String accountPassword) {
		return getNumberInfo(accountNumber, accountPassword, "overdraft") == 1;
	}
	
	public int getAccountNumber(int accountNumber, String accountPassword) {
		return (int) getNumberInfo(accountNumber, accountPassword, "accountNumber");
	}
	
	public String getAccountPassword(int accountNumber, String accountPassword) {
		return getStringInfo(accountNumber, accountPassword, "accountPassword");
	}
	
	public int getTotalAccounts() {
		return (int) getNumberInfo(0, "accountAccess", "totalAccounts");
	}
	
	private double getNumberInfo(int accountNumber, String accountPassword, String infoToRetrieve) {
		double info = 0;
		try {
			//System.out.println(connectingMessage);
			bankAccountDB = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println(creatingSQLCommandMessage);
			sql = String.format("SELECT %s FROM BankAccounts WHERE accountNumber=%d AND accountPassword='%s';", infoToRetrieve, accountNumber, accountPassword);
			bankAccountDBStatement = bankAccountDB.createStatement();
			//System.out.println(communicatingWithDBMessage);
			accountInfo = bankAccountDBStatement.executeQuery(sql);
			accountInfo.next();
			info = accountInfo.getDouble(infoToRetrieve);
			accountInfo.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//System.out.println(closingMessage);
				if (bankAccountDBStatement != null) {
					bankAccountDBStatement.close();
				}
			} catch (SQLException se){
			}
			try {
				if (bankAccountDB != null) {
					bankAccountDB.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return info;
	}
	
	private String getStringInfo(int accountNumber, String accountPassword, String infoToRetrieve){
		String info = "";
		try {
			//System.out.println(connectingMessage);
			bankAccountDB = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println(creatingSQLCommandMessage);
			sql = String.format("SELECT %s FROM BankAccounts WHERE accountNumber=%d AND accountPassword='%s';", infoToRetrieve, accountNumber, accountPassword);
			bankAccountDBStatement = bankAccountDB.createStatement();
			//System.out.println(communicatingWithDBMessage);
			accountInfo = bankAccountDBStatement.executeQuery(sql);
			accountInfo.next();
			info = accountInfo.getString(infoToRetrieve);
			accountInfo.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//System.out.println(closingMessage);
				if (bankAccountDBStatement != null) {
					bankAccountDBStatement.close();
				}
			} catch (SQLException se){
			}
			try {
				if (bankAccountDB != null) {
					bankAccountDB.close();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
		return info;
	}
}
	