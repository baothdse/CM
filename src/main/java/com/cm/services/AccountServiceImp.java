package com.cm.services;

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
	public AccountEntity findById(Long id) {
		return accountRepository.findOne(id);
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

}
