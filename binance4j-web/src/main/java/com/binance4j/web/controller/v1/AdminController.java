package com.binance4j.web.controller.v1;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.web.entity.Credentials;
import com.binance4j.web.entity.InMemoryUserDetails;
import com.binance4j.web.service.InMemoryUserDetailsService;
import com.binance4j.web.service.JwtService;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
	@Autowired
	InMemoryUserDetails inMemoryUserDetails;
	@Autowired
	InMemoryUserDetailsService inMemoryUserDetailsService;
	@Autowired
	JwtService jwtService;

	@PostMapping("auth/login")
	public ResponseEntity<Void> login(@RequestBody Credentials credentials)
			throws UnsupportedEncodingException, ApiException {
		System.out.println(credentials);
		if (inMemoryUserDetailsService.validateCredentials(credentials)) {
			var headers = jwtService.generateJwtHeaders(inMemoryUserDetails);
			return ResponseEntity.ok().headers(headers).build();
		}
		throw new NotFoundException();
	}
}
