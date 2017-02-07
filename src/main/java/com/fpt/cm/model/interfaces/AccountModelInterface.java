package com.fpt.cm.model.interfaces;

import com.fpt.cm.entities.AccountEntity;

public interface AccountModelInterface {
	AccountEntity getAccountByUsername(String username);
	
}
