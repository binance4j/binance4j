package com.binance4j.margin.dto;

/** Status of a submitted order. */
public enum LoanStatus {
	/** Pending execution */
	PENDING,
	/** Successfully loaned */
	CONFIRMED,
	/** Execution failed, nothing happened to your account */
	FAILED
}