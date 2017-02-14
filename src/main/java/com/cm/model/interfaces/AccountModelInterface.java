package com.cm.model.interfaces;

import com.cm.entity.AccountEntity;

public interface AccountModelInterface {
	AccountEntity getAccountByUsername(String username);
}
