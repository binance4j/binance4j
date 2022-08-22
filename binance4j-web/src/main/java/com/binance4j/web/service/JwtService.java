package com.binance4j.web.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/** Handles JWT. */
@Service
public class JwtService {
	private String refreshTokenName = "Refresh";
	private String accessTokenName = "Authorization";
	private Long refreshTokenValidity = 31536000L;
	private Long accessTokenValidity = 900L;
	private String jwtSecret = "keyboard cat";

	/**
	 * @param token The token.
	 * @return Username from token.
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * 
	 * @param token The token.
	 * @return Expiration date from token.
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Get specific claim from token.
	 * 
	 * @param <T>            claim type.
	 * @param token          token.
	 * @param claimsResolver claims resolver.
	 * @return claim.
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		return claimsResolver.apply(getAllClaimsFromToken(token));
	}

	/**
	 * @param token token
	 * @return all claims from token
	 */
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(getJwtSecret()).parseClaimsJws(token).getBody();
	}

	/**
	 * @param token token.
	 * @return if token is expired
	 */
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * @param userDetails user details
	 * @param validity    token validity
	 * @return a token from a user details
	 */
	public String generateToken(UserDetails userDetails, Long validity) {
		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validity))
				.signWith(SignatureAlgorithm.HS512, getJwtSecret())
				.compact();
	}

	/**
	 * Validate token by checking token validity and username in token.
	 * 
	 * @param token token.
	 * @param user  user.
	 * @return toekn validation.
	 */
	public Boolean validateToken(String token, UserDetails user) {
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * 
	 * @param userDetails user details.
	 * @return headers with generated access and refresh tokens.
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
	 */
	public HttpHeaders generateJwtHeaders(UserDetails userDetails) throws UnsupportedEncodingException {
		HttpHeaders headers = new HttpHeaders();
		headers.add(getAccessTokenName(), generateAccessToken(userDetails));
		headers.add(getRefreshTokenName(), generateRefreshToken(userDetails));

		return headers;
	}

	/**
	 * Generates an access token from a user details.
	 * 
	 * @param userDetails user details.
	 * @return a jwt from the user details.
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
	 */
	public String generateAccessToken(UserDetails userDetails) throws UnsupportedEncodingException {
		return URLEncoder.encode(generateToken(userDetails, getAccessTokenValidity() * 1000),
				StandardCharsets.UTF_8.toString());
	}

	/**
	 * Generates a refresh token from a user details.
	 * 
	 * @param userDetails user details.
	 * @return a jwt from the user details.
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
	 */
	public String generateRefreshToken(UserDetails user) throws UnsupportedEncodingException {
		return URLEncoder.encode(generateToken(user, getRefreshTokenValidity() * 1000),
				StandardCharsets.UTF_8.toString());
	}

	/**
	 * @return the refreshTockenValidity
	 */
	public Long getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	/**
	 * @param refreshTokenValidity the refreshTockenValidity to set
	 */
	public void setRefreshTokenValidity(Long refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	/**
	 * @return the accessTokenValidity
	 */
	public Long getAccessTokenValidity() {
		return accessTokenValidity;
	}

	/**
	 * @param accessTokenValidity the accessTokenValidity to set
	 */
	public void setAccessTokenValidity(Long accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	/**
	 * @return the refreshTokenName
	 */
	public String getRefreshTokenName() {
		return refreshTokenName;
	}

	/**
	 * @param refreshTokenName the refreshTokenName to set
	 */
	public void setRefreshTokenName(String refreshTokenName) {
		this.refreshTokenName = refreshTokenName;
	}

	/**
	 * @return the accessTokenName
	 */
	public String getAccessTokenName() {
		return accessTokenName;
	}

	/**
	 * @param accessTokenName the accessTokenName to set
	 */
	public void setAccessTokenName(String accessTokenName) {
		this.accessTokenName = accessTokenName;
	}

	/**
	 * @return the jwtSecret
	 */
	public String getJwtSecret() {
		return jwtSecret;
	}

	/**
	 * @param jwtSecret the jwtSecret to set
	 */
	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

}