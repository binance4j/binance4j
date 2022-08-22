package com.binance4j.web.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.web.dto.AdminDetails;
import com.binance4j.web.dto.Credentials;
import com.binance4j.web.service.AdminDetailsService;
import com.binance4j.web.service.JwtService;

/** Admin management controller. */
@RestController
@RequestMapping("api/admin")
public class AdminController {
	@Autowired
	AdminDetails adminDetails;
	@Autowired
	AdminDetailsService inMemoryUserDetailsService;
	@Autowired
	JwtService jwtService;

	/**
	 * Compares sent credentials with admin credentials. If ok, return ok with jwt
	 * headers, else 404.
	 * 
	 * @param credentials The user credentials
	 * @return 200 with jwt headers or 404.
	 * @throws ApiException Something went wrong.
	 */
	@PostMapping("auth/login")
	public ResponseEntity<Void> login(@RequestBody Credentials credentials) throws ApiException {
		return inMemoryUserDetailsService.validateCredentials(credentials)
				? ResponseEntity.ok().headers(jwtService.generateJwtHeaders(adminDetails)).build()
				: ResponseEntity.notFound().build();
	}
}
