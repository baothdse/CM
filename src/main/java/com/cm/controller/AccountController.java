package com.cm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.cm.error.CustomError;
import com.cm.services.interfaces.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = URLConstants.LOGIN_URL, method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam(value = ParamConstants.USERNAME) String username,
			@RequestParam(value = ParamConstants.PASSWORD) String password) {
		
		AccountEntity profile = accountService.findByUserName(username);
		if (profile == null || !profile.getPassword().equals(password)) {
			CustomError err = new CustomError(ErrorConstants.ER001, ErrorConstants.EM001);
			return new ResponseEntity<CustomError>(err, HttpStatus.OK);
		}
		return new ResponseEntity<AccountEntity>(profile, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstants.REGISTER_URL, method = RequestMethod.POST) 
	public ResponseEntity<?> register(@RequestParam(value = ParamConstants.USERNAME) String username, 
									@RequestParam(value = ParamConstants.PASSWORD) String password, 
									@RequestParam(value = ParamConstants.NAME_OF_CUSTOMER) String nameOfCustomer,
									@RequestParam(value = ParamConstants.BIRTHDATE) String birthdate) throws ParseException {
		Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
		CustomError error = new CustomError(ErrorConstants.ER009, ErrorConstants.EM009);
		AccountEntity account = new AccountEntity();
		if (accountService.register(account, username, password, nameOfCustomer, dateOfBirth) == true) {
			return new ResponseEntity<AccountEntity> (account, HttpStatus.OK);
		}
		return new ResponseEntity<CustomError> (error, HttpStatus.OK);
		
	}
}
