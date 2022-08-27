package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.binance4j.web.dto.UsernamePasswordUserDetails;
import com.binance4j.web.service.AuthenticationService;

/**
 * Filter to authenticate the user sending their Api keys in the headers
 */
@Component
public class KeysAuthenticationFilter extends OncePerRequestFilter {
	AuthenticationService authenticationService;
	/** is filter enabled? */
	boolean enabled = true;

	/**
	 * Creates instance
	 * 
	 * @param authenticationService Authentication service.
	 */
	public KeysAuthenticationFilter(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// disabled, pass.
		if (!enabled) {
			chain.doFilter(request, response);
			return;
		}

		// Already authenticated, pass.
		if (authenticationService.authenticated()) {
			chain.doFilter(request, response);
			return;
		}

		// Get token from headers.
		UsernamePasswordUserDetails user = new UsernamePasswordUserDetails(request.getHeader("x-api-key"),
				request.getHeader("x-api-secret"));

		// Credentials not complete, pass.
		if (user.getKey() == null || user.getSecret() == null) {
			chain.doFilter(request, response);
			return;
		}

		authenticationService.authenticateUser(user);

		chain.doFilter(request, response);
	}

	/** Enable filter. */
	public void enable() {
		enabled = true;
	}

	/** Disable filter. */
	public void disable() {
		enabled = false;
	}
}