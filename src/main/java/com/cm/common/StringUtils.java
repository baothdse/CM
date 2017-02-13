package com.cm.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringUtils {
	public static boolean matchPassword(String rawPass, String encodedPass) {
		return new BCryptPasswordEncoder().matches(rawPass, encodedPass);
	}
}
