package com.binance4j.margin.dto;

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
public record Asset(String assetFullName, String assetName, @JsonProperty("userMinBorrow") String userMinimumBorrow,
		@JsonProperty("userMinRepay") String userMinimumRepay, boolean isBorrowable, boolean isMortgageable) {
}