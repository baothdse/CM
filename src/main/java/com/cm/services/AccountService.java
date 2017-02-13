package com.cm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cm.common.StringUtils;
import com.cm.entity.AccountEntity;
import com.cm.model.interfaces.AccountModelInterface;
import com.cm.services.interfaces.AccountServiceInterface;

@Service
@Transactional
public class AccountService implements AccountServiceInterface {
	
	@Autowired
	AccountModelInterface accountModelInterface;

	@Override
	public AccountEntity getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return accountModelInterface.getAccountByUsername(username);
	}

	@Override
	public AccountEntity authenticate(String username, String password) {
		// TODO Auto-generated method stub
		AccountEntity accountEntity = accountModelInterface.getAccountByUsername(username);
		if (accountEntity != null) {
			if (StringUtils.matchPassword(password, accountEntity.getPassword())) {
				return accountEntity;
			}
		}
		return null;
	}
	
	
	
}
