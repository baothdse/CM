package com.cm.model.interfaces;

import com.cm.entities.AccountEntity;

public interface AccountModelInterface {
	AccountEntity getAccountByUsername(String username);
}
