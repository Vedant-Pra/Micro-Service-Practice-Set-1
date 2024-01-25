package com.example.demo.Repo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Account;
import com.example.demo.exception.ApplicaionNotFoundException;

@Component(value="accountRepository")
public interface AccountRepository {
	Account createAccount(Account account);
	List<Account> getAllAccount();
	Account getAccountByAccountId(String accountNumber) throws ApplicaionNotFoundException;
	Account updateAccountbyNumber(String accountNumber,Account account) throws ApplicaionNotFoundException;
	Account getAccountByEmail(String email) throws ApplicaionNotFoundException;
}
