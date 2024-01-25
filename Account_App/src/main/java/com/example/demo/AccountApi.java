package com.example.demo;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Account;
import com.example.demo.Services.ApplicationService;
import com.example.demo.exception.ui.ErrorResponse;

import lombok.AllArgsConstructor;
import com.example.demo.exception.*;
@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountApi {
	private final ApplicationService applicationService;
	
	@ExceptionHandler
	public ErrorResponse handelException(ApplicaionNotFoundException e) {
		ErrorResponse response = new ErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setToOfError(System.currentTimeMillis());
		return response;
	}
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return applicationService.createAccount(account);
	}
	@GetMapping
	public List<Account> listAccounts(){
		return applicationService.getAllAccounts();
	}
	@GetMapping("/{accountNumber}")
	public Account getAccountByNumber(@PathVariable("accountNumber") String accountNumber) throws ApplicaionNotFoundException{
		return applicationService.getAccountByAccountId(accountNumber);
	}
	@PutMapping("/{accountNumber}")
	public Account updateAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody Account account) throws ApplicaionNotFoundException{
		return applicationService.updateAccountbyNumber(accountNumber, account);
	}
	@GetMapping("/email/{email}")
	public Account getAccountByMail(@PathVariable("email") String email) throws ApplicaionNotFoundException{
		return applicationService.getAccountByEmail(email);
	}
}
