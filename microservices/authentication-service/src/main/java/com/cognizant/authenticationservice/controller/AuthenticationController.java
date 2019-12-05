package com.cognizant.authenticationservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start of authenticate");
		Map<String, String> map = new HashMap<String, String>();
		String user = getUser(authHeader);
		String JWT = generateJwt(user);
		LOGGER.info(JWT);
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		LOGGER.info(role);
		LOGGER.debug("JWT:{}", JWT);
		map.put("token", JWT);
		map.put("role", role);
		map.put("username", user);
		LOGGER.info("End of authenticate");
		return map;
	}

	private String getUser(String authHeader) {
		LOGGER.info("Start of getUser");
		String encodedCredentials = authHeader.substring(6);
		byte[] decode = Base64.getDecoder().decode(encodedCredentials);
		String pair = new String(decode);
		String[] userDetails = pair.split(":", 2);
		LOGGER.info(pair);
		LOGGER.info("End of getUser");
		return userDetails[0];

	}

	private String generateJwt(String user) {
		LOGGER.info("Start of generateJwt");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		builder.setIssuedAt(new Date());

		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info(token);
		LOGGER.info("End of generateJwt");
		return token;
	}

}
