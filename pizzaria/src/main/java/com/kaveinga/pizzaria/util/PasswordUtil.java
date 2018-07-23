package com.kaveinga.pizzaria.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
	private static int passwordMinLength = 7;
	private static int passwordMaxLength = 32;
	final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private PasswordUtil() {
	}

	/*
	 * Password for development only
	 */
	public static String hashPassword(final String password) {
		if (password == null || password.length() < 1)
			throw new RuntimeErrorException(null, "Password must not be null");
		else
			return passwordEncoder.encode(password);
	}
	
	public static boolean verify(String password, String hashPassword) {
		return passwordEncoder.matches(password, hashPassword);
	}
	
	public static boolean isPasswordValid(String password) {
		Pattern numberContainRegex = Pattern.compile("/d/");
		Pattern uppercaseContainRegex = Pattern.compile("/[A-Z]/");
		return true;
	}
	

	public static String getRandomTempPassword() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	public static boolean validatePassword(String password) {
		if (isPasswordCharactersGood(password) && isPasswordLengthGood(password)) {
			return true;
		}
		return false;
	}

	private static boolean isPasswordLengthGood(String password) {
		String pwd = password.trim();
		if (pwd.length() >= passwordMinLength && pwd.length() <= passwordMaxLength) {
			return true;
		}
		System.out.println("password length is not valid");
		return false;
	}

	private static boolean isPasswordCharactersGood(String password) {
		// one uppercase letter and one number
		String pattern = "(?=.*?[A-Z])(?=.*?[0-9])";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(password);
		
		if(m.find()){
			return true;
		}
		System.out.println("could not find one number and one upper case letter");
		return false;
	}
}
