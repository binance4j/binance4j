package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.binance4j.web.dto.AnonymousUserDetails;

/**
 * Filter to authenticate the user sending their Api keys in the headers
 */
@Component
public class KeysAuthenticationFilter extends AuthenticationFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// Already authenticated, pass.
		if (isAlreadyAuthenticated()) {
			chain.doFilter(request, response);
			return;
		}

		// Get token from headers.
		AnonymousUserDetails user = new AnonymousUserDetails(request.getHeader("x-api-key"),
				request.getHeader("x-api-secret"));

		System.out.println(user);

		// Credentials not complete, pass.
		if (user.getKey() == null || user.getSecret() == null) {
			chain.doFilter(request, response);
			return;
		}

		authenticateUser(user, user.getKey(), user.getSecret());

		chain.doFilter(request, response);
	}

}