package com.binance4j.margin.dto;

import com.binance4j.margin.client.MarginClient;

/**
 * BNB burn status after {@link MarginClient#toggleBNBBurnOnSpotTradeAndMarginInterest}
 * 
 * @param spotBNBBurn     Is spot BNB burn allowed.
 * @param interestBNBBurn Is interest BNB burn allowed.
 */
public record BNBBurnStatus(boolean spotBNBBurn, boolean interestBNBBurn) {
}