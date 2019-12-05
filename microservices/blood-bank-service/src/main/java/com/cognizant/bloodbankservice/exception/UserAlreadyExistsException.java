package com.cognizant.bloodbankservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAlreadyExistsException.class);

	public UserAlreadyExistsException() {
		LOGGER.info("User Already Exists");
	}

}
