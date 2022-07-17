package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiTradingStatusTriggerCondition(/** Number of GTC orders. */
@JsonProperty("GCR") long gcr,
		/** Number of FOK/IOC orders. */
		@JsonProperty("IFER") long ifer, /** Number of FOK/IOC orders. */
		@JsonProperty("UFR") long ufr) {
}
