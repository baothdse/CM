package com.fpt.cm.model;

import com.fpt.cm.entities.AccountEntity;
import com.fpt.cm.model.common.commonDAO;
import com.fpt.cm.model.interfaces.AccountModelInterface;
import org.springframework.stereotype.Repository;

public class AccountModel extends commonDAO implements AccountModelInterface {
	
	public AccountEntity getAccountByUsername(String username) {
		AccountEntity accountEntity = getSession().get(AccountEntity.class, username);
		return accountEntity;
	}
}
