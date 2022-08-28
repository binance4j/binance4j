package com.binance4j.web.dto;

/**
 * Authentication credentials
 */
public class Credentials {
	/** Username. */
	String username;
	/** Password. */
	String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @property username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @property password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [password=" + password + ", username=" + username + "]";
	}
}
