package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.binance4j.web.service.AdminDetailsService;
import com.binance4j.web.service.JwtService;

/**
 * Filter to authenticate the admin user via a JWT access token in the headers.
 */
@Component
public class AdminAuthenticationFilter extends AuthenticationFilter {
	@Autowired
	AdminDetailsService adminDetailsService;
	@Autowired
	JwtService jwtService;

	UsernamePasswordAuthenticationToken authToken;
	String username;
	UserDetails userDetails;
	String accessToken;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// Already authenticated, pass.
		if (isAlreadyAuthenticated()) {
			chain.doFilter(request, response);
			return;
		}

		// Get token from headers.
		accessToken = request.getHeader(jwtService.getAccessTokenName());

		// No token, continue chain.
		if (accessToken == null) {
			chain.doFilter(request, response);
			return;
		}

		// Token expired, tell to refresh jwt.
		try {
			jwtService.isTokenExpired(accessToken);
		} catch (Exception e) {
			request.setAttribute("jwt", "refresh");
		}

		username = jwtService.getUsernameFromToken(accessToken);
		userDetails = adminDetailsService.loadUserByUsername(username);

		// User not found, continue chain.
		if (userDetails == null) {
			chain.doFilter(request, response);
			return;
		}

		authenticateUser(userDetails, adminDetailsService.getAdminDetails().getKey(),
				adminDetailsService.getAdminDetails().getSecret());

		chain.doFilter(request, response);
	}

}