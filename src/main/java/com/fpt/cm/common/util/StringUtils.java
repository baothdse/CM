package com.fpt.cm.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringUtils {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static boolean matchPassword(String rawPass, String encodedPass) {
		return new BCryptPasswordEncoder().matches(rawPass, encodedPass);
	}
}
