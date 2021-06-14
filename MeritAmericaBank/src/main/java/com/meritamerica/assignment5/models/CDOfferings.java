package com.meritamerica.assignment5.models;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CDOfferings {
	@NotNull(message = "no term found")
	Integer term;
	@NotNull(message = "no interest rate found")
Double interestRate;
	
	public CDOfferings() {
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}