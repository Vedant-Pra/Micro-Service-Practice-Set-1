package com.example.demo.Repo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.demo.Model.Account;
import com.example.demo.exception.ApplicaionNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Component(value="accountRepository")
@EnableTransactionManagement
@AllArgsConstructor
public class AccountRepositoryImplementation implements AccountRepository{
	private final SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(account);
		session.getTransaction().commit();
		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		TypedQuery<Account> query = session.createQuery("FROM Account A", Account.class);
		return query.getResultList();
	}

	@Override
	public Account getAccountByAccountId(String accountNumber) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Account account = session.get(Account.class, accountNumber);
		if(account==null) {
			throw new ApplicaionNotFoundException("account with" + accountNumber + "not found");
		}
		return account;
		
	}

	@Override
	public Account updateAccountbyNumber(String accountNumber, Account account) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		Account tempAccount = getAccountByAccountId(accountNumber);
		if(tempAccount==null) {
			throw new ApplicaionNotFoundException("Account with " + accountNumber + "not found");
		}
		Session session = sessionFactory.openSession();
		tempAccount.setAccountHolderName(account.getAccountHolderName());
		tempAccount.setAccountHolderAddress(account.getAccountHolderAddress());
		tempAccount.setAccountNumber(account.getAccountNumber());
		tempAccount.setEmail(account.getEmail());
		session.getTransaction().begin();
		session.merge(tempAccount);
		session.getTransaction().commit();
		return tempAccount;
		
	}

	@Override
	public Account getAccountByEmail(String email) throws ApplicaionNotFoundException {
		// TODO Auto-generated method stub
		Session session =sessionFactory.openSession();
		TypedQuery<Account> typedQuery = session.createQuery("FROM Account a WHERE a.email = :email", Account.class);
		typedQuery.setParameter("email", email);
		if(typedQuery.getResultList().size()==0)
			throw new ApplicaionNotFoundException("Account with "+email+"not found");
		return typedQuery.getResultList().get(0);
	}
}
