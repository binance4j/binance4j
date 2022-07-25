package com.binance4j.core.dto;

/** The request weight type. */
public enum RateLimitType {
	/** Account related */
	UID,
	/** IP related */
	IP,
	/** Account and IP related */
	UID_AND_IP
}
