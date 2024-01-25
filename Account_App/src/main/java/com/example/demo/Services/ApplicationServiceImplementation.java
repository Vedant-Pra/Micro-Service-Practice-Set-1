package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Account;
import com.example.demo.Repo.AccountRepository;
import com.example.demo.exception.ApplicaionNotFoundException;

import lombok.AllArgsConstructor;
@Component(value="applicationService")
@AllArgsConstructor
public class ApplicationServiceImplementation implements ApplicationService{

	private final AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.createAccount(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.getAllAccount();
	}

	@Override
	public Account getAccountByAccountId(String accountNumber) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByAccountId(accountNumber);
	}

	@Override
	public Account updateAccountbyNumber(String accountNumber, Account account) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.updateAccountbyNumber(accountNumber, account);
		
	}

	@Override
	public Account getAccountByEmail(String email) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.getAccountByEmail(email);
	}

}
