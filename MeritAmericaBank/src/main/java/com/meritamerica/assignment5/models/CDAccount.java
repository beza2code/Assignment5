package com.meritamerica.assignment5.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class CDAccount {
	static int nextId = 1;
	
	int id;
	@NotNull(message = "Cannot be Blank")
	@NotBlank(message = "Cannot be Blank")
	String firstName;
	
	String middleName;
	
	@NotBlank(message = "Cannot be Blank")
	@NotNull(message = "Cannot be Blank")
	String lastName;
	
	@NotBlank(message = "Cannot be Blank")
	@NotNull(message = "Cannot be Blank")
	String ssn;
	
	
	List<CheckingAccount> checkingAccs = new ArrayList<CheckingAccount>();
	List<SavingsAccount> savingsAccs = new ArrayList<SavingsAccount>();
	List<CDAccount> cdAccounts = new ArrayList<CDAccount>();
	
	public CDAccount() {
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.ssn = "";
		this.id = nextId++;
	}

	public CheckingAccount addChecking(CheckingAccount checking) {
		checkingAccs.add(checking);
		return checking;
	}
	
	public List<CheckingAccount> getCheckingAccount() {
		return checkingAccs;
	}
	
	public SavingsAccount addSavings(SavingsAccount savings) {
		savingsAccs.add(savings);
		return savings;
	}
	
	
	public List<SavingsAccount> getSavingsAccount() {
		return savingsAccs;
	}
	
	public  CDAccount addCDAccounts(CDAccount cdaccount) {
		cdAccounts.add(cdaccount);
		return cdaccount;
	}
	
	public List<CDAccount> getCDAccount() {
		return cdAccounts;
	}
	public int getBalance() {
		return 0;
	}
	public int getInterestRate() {
		return 0;
	}
	public int getTerm() {
		return 0;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
		
