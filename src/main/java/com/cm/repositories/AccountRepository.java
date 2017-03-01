package com.cm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.entities.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	AccountEntity findByUsername(String name);
	
	AccountEntity findByUserId(Long userId);
}
