package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Trading status trigger condition.
 * 
 * @param gcr  Number of GTC orders.
 * @param ifer Number of FOK/IOC orders.
 * @param ufr  Number of FOK/IOC orders.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiTradingStatusTriggerCondition(
		/** Number of GTC orders. */
		@JsonProperty("GCR") long gcr,
		/** Number of FOK/IOC orders. */
		@JsonProperty("IFER") long ifer,
		/** Number of FOK/IOC orders. */
		@JsonProperty("UFR") long ufr) {
}
