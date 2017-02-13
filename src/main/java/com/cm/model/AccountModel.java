package com.cm.model;

import org.springframework.stereotype.Repository;

import com.cm.entity.AccountEntity;
import com.cm.model.interfaces.AccountModelInterface;

@Repository
public class AccountModel extends CommonDAO implements AccountModelInterface {

	@Override
	public AccountEntity getAccountByUsername(String username) {
		AccountEntity accountEntity = getSession().get(AccountEntity.class, username);
		return accountEntity;
	}
	
}	
