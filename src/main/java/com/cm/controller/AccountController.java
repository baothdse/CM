package com.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.common.CustomeErrType;
import com.cm.constants.ParamConstants;
import com.cm.constants.URLConstants;
import com.cm.entity.AccountEntity;
import com.cm.error.ErrorCustome;
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
		if(profile==null){
			ErrorCustome err = new ErrorCustome("403", "Wrong password or username");
			return new ResponseEntity<ErrorCustome>(err, HttpStatus.OK);
		}else if(!profile.getPassword().equals(password)){
			ErrorCustome err = new ErrorCustome("403", "Wrong password or username");
			return new ResponseEntity<ErrorCustome>(err, HttpStatus.OK);
		}
		return new ResponseEntity<AccountEntity>(profile, HttpStatus.OK); 
	}
}
