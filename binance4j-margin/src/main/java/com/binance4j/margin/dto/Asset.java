package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** Asset full name. */
		String assetFullName,
		/** Asset name. */
		String assetName,
		/** Is it borrowable? */
		boolean isBorrowable,
		/** Is it mortgageable? */
		boolean isMortgageable,
		/** User minimum borrow. */
		@JsonProperty("userMinBorrow") BigDecimal userMinimumBorrow,
		/** User minimum repay. */
		@JsonProperty("userMinRepay") BigDecimal userMinimumRepay) {
}
