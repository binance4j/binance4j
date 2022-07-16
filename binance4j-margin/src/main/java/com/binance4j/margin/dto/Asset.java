package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An asset on the platform
 * 
 * @param assetFullName     The asset full name.
 * @param assetName         The asset name.
 * @param userMinimumBorrow The user minimum borrow.
 * @param userMinimumRepay  The user minimum repay.
 * @param isBorrowable      Is it borrowable?
 * @param isMortgageable    Is it mortgageable?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** The asset full name. */
		String assetFullName,
		/** The asset name. */
		String assetName,
		/** The user minimum borrow. */
		@JsonProperty("userMinBorrow") BigDecimal userMinimumBorrow,
		/** The user minimum repay. */
		@JsonProperty("userMinRepay") BigDecimal userMinimumRepay,
		/** Is it borrowable? */
		boolean isBorrowable,
		/** Is it mortgageable? */
		boolean isMortgageable) {
}