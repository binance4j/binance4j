package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** An asset on the platform */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** The asset full name. */
		String assetFullName,
		/** The asset name. */
		String assetName,
		/** Is it borrowable? */
		boolean isBorrowable,
		/** Is it mortgageable? */
		boolean isMortgageable,
		/** The user minimum borrow. */
		@JsonProperty("userMinBorrow") BigDecimal userMinimumBorrow,
		/** The user minimum repay. */
		@JsonProperty("userMinRepay") BigDecimal userMinimumRepay) {
}