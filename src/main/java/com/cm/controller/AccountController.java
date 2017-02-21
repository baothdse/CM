package com.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.ErrorConstants;
import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entities.AccountEntity;
import com.cm.error.CustomerError;
import com.cm.services.interfaces.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = URLConstants.LOGIN_URL, method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam(value=ParamConstants.USERNAME) String username,
			                       @RequestParam(value=ParamConstants.PASSWORD) String password){
		AccountEntity profile = accountService.findByUserName(username);
		if( profile==null || !profile.getPassword().equals(password)){
			CustomerError err = new CustomerError(ErrorConstants.ER001, ErrorConstants.EM001);
			return new ResponseEntity<CustomerError>(err, HttpStatus.OK);
		}
		return new ResponseEntity<AccountEntity>(profile, HttpStatus.OK); 
	}
}
