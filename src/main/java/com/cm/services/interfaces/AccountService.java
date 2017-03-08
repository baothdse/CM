package com.cm.services.interfaces;

import java.util.Date;
import java.util.List;

import com.cm.entities.AccountEntity;


public interface AccountService {
	AccountEntity findById(Long userID);
	void updateProfile(AccountEntity account);
	void saveAccount(AccountEntity account);
	AccountEntity findByUserName(String username);
	boolean register(AccountEntity account, String username, String password, String nameOfCustomer, Date birthdate);
	List<AccountEntity> getAllUser();
}
