package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.Model.Account;
import com.example.demo.Repo.AccountRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class AccountAppApplication implements CommandLineRunner{
	public final AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(AccountAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountRepository.createAccount(new Account(UUID.randomUUID().toString(), "Sachin", "Mumbai", "sachin@gmail.com"));
		accountRepository.createAccount(new Account(UUID.randomUUID().toString(), "Rahul", "Banglore", "rahul@gmail.com"));
	}

}
