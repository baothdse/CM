package com.fpt.cm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fpt.cm.common.util.StringUtils;
import com.fpt.cm.entities.AccountEntity;
import com.fpt.cm.model.interfaces.AccountModelInterface;
import com.fpt.cm.service.interfaces.AccountServiceInterface;

public class AccountService implements AccountServiceInterface {
	@Autowired
	AccountModelInterface accountModelInterface;
	
	public AccountEntity getAccountByUsername(String username) {
		return accountModelInterface.getAccountByUsername(username);
	}

	public AccountEntity authenticate(String username, String password) {
		AccountEntity accountEntity = accountModelInterface.getAccountByUsername(username);
		if (accountEntity != null) {
			if (StringUtils.matchPassword(password, accountEntity.getPassword())) {
				return accountEntity;
			}
		}
		return null;
	}
}
