package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The authenticated account api trading status detail.
 * 
 * @param data The trading status data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiTradingStatus(
		/** The trading status data. */
		ApiTradingStatusData data) {
}