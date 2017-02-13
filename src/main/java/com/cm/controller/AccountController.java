package com.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entity.AccountEntity;
import com.cm.services.interfaces.AccountServiceInterface;

@RestController
public class AccountController {
	@Autowired
    AccountServiceInterface accountServiceInterface;
	
	@ResponseBody
	@RequestMapping(value = URLConstants.AUTHENTICATION_URL, method = RequestMethod.POST)
    public AccountEntity getAccount(@RequestParam(value = ParamConstants.USERNAME) String username,
    								@RequestParam(value = ParamConstants.PASSWORD) String password) {
		return accountServiceInterface.authenticate(username, password);
	}
}
