package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Max Borrow Query Result
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxBorrowableResponse(
		/** TODO JAVADOC. */
		BigDecimal amount,
		/** TODO JAVADOC. */
		BigDecimal borrowLimit) {
}