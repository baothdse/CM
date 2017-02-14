package com.cm.services.interfaces;

import com.cm.entity.AccountEntity;


public interface AccountService {
	AccountEntity findById(Long id);
	void updateProfile(AccountEntity account);
	void saveAccount(AccountEntity account);
	AccountEntity findByUserName(String username);
}
