package com.fpt.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fpt.cm.common.constant.ParamConstant;
import com.fpt.cm.common.constant.URLConstant;
import com.fpt.cm.entities.AccountEntity;
import com.fpt.cm.service.interfaces.AccountServiceInterface;

@Controller
public class AccountController {
	
	@Autowired
	AccountServiceInterface accountServiceInterface;
	@ResponseBody
	@RequestMapping(value = URLConstant.AUTHENTICATION, method = RequestMethod.POST)
	public AccountEntity getAccount(@RequestParam(value = ParamConstant.USERNAME) String username,
            @RequestParam(value = ParamConstant.PASSWORD) String password) {
		return accountServiceInterface.authenticate(username, password);
	}
}
