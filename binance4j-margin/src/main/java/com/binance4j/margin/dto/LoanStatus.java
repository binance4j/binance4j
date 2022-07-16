package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Status of a submitted order. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LoanStatus {
	/** Pending execution */
	PENDING,
	/** Successfully loaned */
	CONFIRMED,
	/** Execution failed, nothing happened to your account */
	FAILED
}