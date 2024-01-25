package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Account;
import com.example.demo.exception.ApplicaionNotFoundException;

public interface ApplicationService {
	Account createAccount(Account account);
	List<Account> getAllAccounts();
	Account getAccountByAccountId(String accountNumber) throws ApplicaionNotFoundException;
	Account updateAccountbyNumber(String accountNumber,Account account) throws ApplicaionNotFoundException;
	public Account getAccountByEmail(String email) throws ApplicaionNotFoundException; 
}
