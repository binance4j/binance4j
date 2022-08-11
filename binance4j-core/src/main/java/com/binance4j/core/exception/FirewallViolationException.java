package com.binance4j.core.exception;

/** Thrown when The Web Application Firewall has been violated. */
public class FirewallViolationException extends ApiException {
	/** Constructor */
	public FirewallViolationException() {
		super(403, "The Web Application Firewall has been violated");
	}
}
