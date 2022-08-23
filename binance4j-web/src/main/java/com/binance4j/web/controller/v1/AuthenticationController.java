package com.binance4j.web.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binance4j.core.exception.ApiException;
import com.binance4j.web.dto.Credentials;
import com.binance4j.web.service.AdminDetailsService;
import com.binance4j.web.service.JwtService;

/** Authentication controller. */
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
	/** Admin authentication service. */
	private final AdminDetailsService adminDetailsService;
	/** JWT management service. */
	private final JwtService jwtService;

	/**
	 * Creates instance.
	 * 
	 * @param adminDetailsService Admin authentication service.
	 * @param jwtService          JWT management service.
	 */
	public AuthenticationController(AdminDetailsService adminDetailsService, JwtService jwtService) {
		this.adminDetailsService = adminDetailsService;
		this.jwtService = jwtService;
	}

	/**
	 * Compares sent credentials with admin credentials. If ok, return ok with jwt
	 * headers, else 404.
	 * 
	 * @param credentials The user credentials
	 * @return 200 with jwt headers or 404.
	 * @throws ApiException Something went wrong.
	 */
	@PostMapping("login")
	public ResponseEntity<Void> login(@RequestBody Credentials credentials) throws ApiException {
		UserDetails admin = adminDetailsService.loadUser(credentials);

		if (admin != null) {
			ResponseEntity.ok().headers(jwtService.generateJwtHeaders(admin));
		}

		return ResponseEntity.notFound().build();
	}
}
