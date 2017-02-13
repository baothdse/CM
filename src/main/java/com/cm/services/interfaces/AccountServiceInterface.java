package com.cm.services.interfaces;

import com.cm.entity.AccountEntity;

public interface AccountServiceInterface {
	AccountEntity getAccountByUsername(String username);
	AccountEntity authenticate(String username, String password);
}
