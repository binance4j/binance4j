package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.dto.Binance4jUserDetails;
import com.binance4j.web.service.Binance4jUserDetailsService;
import com.binance4j.web.service.JwtService;

/**
 * Generic jwt authentication filter.
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	/** user authentication service. */
	Binance4jUserDetailsService userDetailsService;
	/** JWT management service. */
	JwtService jwtService;
	/** Binance4j connectors. */
	Connectors connectors;
	/** is filter enabled? */
	boolean enabled = true;

	/**
	 * Creates instance
	 * 
	 * @param userDetailsService user authentication service.
	 * @param jwtService         JWT management service.
	 * @param connectors         Binance4j connectors.
	 */
	public JwtAuthenticationFilter(Binance4jUserDetailsService userDetailsService, JwtService jwtService,
			Connectors connectors) {
		this.userDetailsService = userDetailsService;
		this.jwtService = jwtService;
		this.connectors = connectors;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// disabled, pass.
		if (!enabled) {
			chain.doFilter(request, response);
			return;
		}

		// Already authenticated, pass.
		if (isAlreadyAuthenticated()) {
			chain.doFilter(request, response);
			return;
		}

		// Get token from headers.
		String accessToken = request.getHeader(jwtService.getAccessTokenName());

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

		String username = jwtService.getUsernameFromToken(accessToken);
		Binance4jUserDetails userDetails = userDetailsService.loadUserByUsername(username);

		// User not found, continue chain.
		if (userDetails == null) {
			chain.doFilter(request, response);
			return;
		}

		authenticateUser(userDetails);

		chain.doFilter(request, response);
	}

	/**
	 * Authenticate user in the security context.
	 * 
	 * @param userDetails User to authenticate.
	 */
	public void authenticateUser(Binance4jUserDetails userDetails) {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
						userDetails.getAuthorities()));
		connectors.rest().updateKeys(userDetails.getKey(), userDetails.getSecret());
	}

	/**
	 * @return Is user already authenticated?
	 */
	public boolean isAlreadyAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}

	/**
	 * @return the userDetailsService
	 */
	public Binance4jUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	/**
	 * @param userDetailsService the userDetailsService to set
	 */
	public void setUserDetailsService(Binance4jUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * @return the jwtService
	 */
	public JwtService getJwtService() {
		return jwtService;
	}

	/**
	 * @param jwtService the jwtService to set
	 */
	public void setJwtService(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	/**
	 * @return the connectors
	 */
	public Connectors getConnectors() {
		return connectors;
	}

	/**
	 * @param connectors the connectors to set
	 */
	public void setConnectors(Connectors connectors) {
		this.connectors = connectors;
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
