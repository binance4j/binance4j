package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.binance4j.core.exception.ApiException;
import com.binance4j.web.service.InMemoryUserDetailsService;
import com.binance4j.web.service.JwtService;

/**
 * Checking if jwt is in headers and if so, check if it belongs to the in memory
 * user, then authenticates him.
 */
@Component
public class InMemoryUserJwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	InMemoryUserDetailsService inMemoryUserDetailsService;
	@Autowired
	JwtService jwtService;

	String username;
	UserDetails userDetails;
	String accessToken;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		accessToken = request.getHeader(jwtService.getAccessTokenName());

		// If null, do nothing
		if (accessToken == null) {
			chain.doFilter(request, response);
			return;
		}

		// If expired, add it in the headers
		try {
			jwtService.isTokenExpired(accessToken);
		} catch (Exception e) {
			response.addHeader("WWW-Authenticate", "refresh");
		}

		username = jwtService.getUsernameFromToken(accessToken);
		userDetails = inMemoryUserDetailsService.loadUserByUsername(username);

		// If not in memory user, do nothing
		if (userDetails == null) {
			chain.doFilter(request, response);
			return;
		}

		// authenticate in memory user in security context.
		try {
			inMemoryUserDetailsService.authenticateUser();
		} catch (ApiException e) {
			e.printStackTrace();
		}

		chain.doFilter(request, response);
	}

}