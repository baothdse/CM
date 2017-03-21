package com.cm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.entities.AccountEntity;
import com.cm.repositories.AccountRepository;
import com.cm.services.interfaces.AccountService;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountEntity findById(Long userID) {
		return accountRepository.findByUserId(userID);
	}

	@Override
	public void updateProfile(AccountEntity account) {
		saveAccount(account);
	}

	@Override
	public void saveAccount(AccountEntity account) {
		accountRepository.save(account);

	}

	@Override
	public AccountEntity findByUserName(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public boolean register(AccountEntity account, String username, String password, String nameOfCustomer, Date birthdate) {
		// TODO Auto-generated method stub
		List<AccountEntity> listOfAccount = getAllUser();
		String role = "user";
		boolean checkDuplicateUsername = true;
		
		for (int index = 0; index < listOfAccount.size(); index++) {
			if (listOfAccount.get(index).getUsername().equals(username)) {
				checkDuplicateUsername = false;
			} 
		}
		if (checkDuplicateUsername == true) {
			account.setUsername(username);
			account.setPassword(password);
			account.setNameOfCustomer(nameOfCustomer);
			account.setBirthdate(birthdate);
			account.setRole(role);
			account.setIsActive(true);
			accountRepository.save(account);
			return true;
		}
		return false;
	}

	@Override
	public List<AccountEntity> getAllUser() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

}
