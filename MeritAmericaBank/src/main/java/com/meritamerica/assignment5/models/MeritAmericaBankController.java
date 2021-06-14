package com.meritamerica.assignment5.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.meritamerica.assignment5.Exception.BalanceException;
import com.meritamerica.assignment5.Exception.NotFoundException;
import com.meritamerica.assignment5.models.AccountHolder;
import com.meritamerica.assignment5.models.CDAccount;
import com.meritamerica.assignment5.models.CDOfferings;
import com.meritamerica.assignment5.models.CheckingAccount;
import com.meritamerica.assignment5.models.SavingsAccount;


@RestController
public class MeritAmericaBankController {

	List<String> temp = new ArrayList<String>();
	List<CDOfferings> cdOfferings = new ArrayList<CDOfferings>();
	List<AccountHolder> accHolders = new ArrayList<AccountHolder>();
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders")
	public AccountHolder addAcc(@RequestBody @Valid AccountHolder acc){
		accHolders.add(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders")
	 public List<AccountHolder> getAccs() {
		 return accHolders;
	 }
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccById(@PathVariable int id) throws NotFoundException{
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		
		return accHolders.get(id - 1);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingByAccId(@PathVariable int id, @RequestBody CheckingAccount acc) throws NotFoundException, BalanceException {
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceException("Balance cannot be less than 0");
		}
		int cBalance = 0;
		List<CheckingAccount> temp = new ArrayList<CheckingAccount>();
		temp = accHolders.get(id).getCheckingAccount();
		for(int i = 0; i < temp.size(); i++) {
			cBalance += temp.get(i).getBalance();
		}
		
		if(cBalance > 250000) {
			throw new BalanceException("Balance cannot be greater than 250,000");
		}
		accHolders.get(id - 1).addChecking(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingByAccountId(@PathVariable int id) throws NotFoundException {
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		return accHolders.get(id - 1).getCheckingAccount();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsByAccId(@PathVariable int id, @RequestBody SavingsAccount acc) throws NotFoundException, BalanceException{
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceException("Balance cannot be less than 0");
		}
		int cBalance = 0;
		List<SavingsAccount> temp = new ArrayList<SavingsAccount>();
		temp = accHolders.get(id - 1).getSavingsAccount();
		for(int i = 0; i < temp.size(); i++) {
			cBalance += temp.get(i).getBalance();
		}
		if(cBalance > 250000) {
			throw new BalanceException("Balance cannot be greater than 250,000");
		}
		accHolders.get(id - 1).addSavings(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsByAccountId(@PathVariable int id) throws NotFoundException{
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		return accHolders.get(id - 1).getSavingsAccount();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccount addCDAccountByAccId(@PathVariable int id, @RequestBody @Valid CDAccount acc) throws NotFoundException, BalanceException {
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		if(acc.getBalance() < 0) {
			throw new BalanceException("Balance cannot be less than 0");
		}
		if(acc.getInterestRate() <= 0 || acc.getInterestRate() >= 1) {
			throw new BalanceException("Interest rate cannot be less than 0, cannot be greater than 1");
		}
		if(acc.getTerm() < 1) {
			throw new BalanceException("Term cannot be less than 1");
		}
		accHolders.get(id - 1).addCDAccounts(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	public List<CDAccount> getCDAccountsByAccountId(@PathVariable int id) throws NotFoundException {
		if(id > accHolders.size()) {
			
			throw new NotFoundException("id does not exist");
		}
		return accHolders.get(id - 1).getCDAccount();
	}
	
	@ResponseStatus(HttpStatus.CREATED)	
	@PostMapping(value = "/CDOfferings")
	public CDOfferings addCDOffering(@RequestBody @Valid CDOfferings off) throws BalanceException {
		if(off.getTerm() < 1) {
			throw new BalanceException("Term cannot be less than 1");
		}
		if(off.getInterestRate() <= 0 || off.getInterestRate() >= 1) {
			throw new BalanceException("Interest rate cannot be less than 0, cannot be greater than 1");
		}
		cdOfferings.add(off);
		return off;
	}
	
	@GetMapping(value = "/CDOfferings")
	public List<CDOfferings> getCDOfferings() {
		return cdOfferings;
	}
}