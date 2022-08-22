package com.binance4j.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.binance4j.connectors.Connectors;
import com.binance4j.web.dto.AdminDetails;
import com.binance4j.web.service.AdminDetailsService;
import com.binance4j.web.service.JwtService;

/**
 * Filter to authenticate the admin user.
 */
@Component
public class AdminAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	AdminDetailsService adminDetailsService;
	@Autowired
	JwtService jwtService;
	@Autowired
	AdminDetails adminDetails;
	@Autowired
	Connectors connectors;
	UsernamePasswordAuthenticationToken authToken;
	String username;
	UserDetails userDetails;
	String accessToken;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
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

		authenticateUser(userDetails, adminDetails.getKey(), adminDetails.getSecret());
		// authenticate in memory user in security context.
		try {
			authToken = new UsernamePasswordAuthenticationToken(
					adminDetails.getUsername(), adminDetails.getPassword(),
					adminDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

		chain.doFilter(request, response);
	}

	/**
	 * Authenticate user in the security context.
	 * 
	 * @param userDetails User to authenticate.
	 * @param key         API public key.
	 * @param secret      API secret key.
	 */
	public void authenticateUser(UserDetails userDetails, String key, String secret) {
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
				adminDetails.getUsername(), adminDetails.getPassword(),
				adminDetails.getAuthorities()));
		connectors.rest().updateKeys(key, secret);
	}
}