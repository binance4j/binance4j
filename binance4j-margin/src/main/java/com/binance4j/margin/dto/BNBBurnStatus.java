package com.binance4j.margin.dto;

import com.binance4j.margin.client.MarginClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * BNB burn status after {@link MarginClient#toggleBNBBurnOnSpotTradeAndMarginInterest}
 * 
 * @param spotBNBBurn     Is spot BNB burn allowed.
 * @param interestBNBBurn Is interest BNB burn allowed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BNBBurnStatus(
		/** Is spot BNB burn allowed */
		boolean spotBNBBurn,
		/** Is interest BNB burn allowed */
		boolean interestBNBBurn) {
}