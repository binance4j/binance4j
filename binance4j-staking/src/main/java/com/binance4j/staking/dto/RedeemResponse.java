package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A staking redeem response. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RedeemResponse(
		/** Was the transaction successfull? */
		boolean success) {
}