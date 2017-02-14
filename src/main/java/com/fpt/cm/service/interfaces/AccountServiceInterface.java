package com.fpt.cm.service.interfaces;

import com.fpt.cm.entities.AccountEntity;

public interface AccountServiceInterface {
	AccountEntity getAccountByUsername (String username);
	AccountEntity authenticate(String username, String password);
}
