package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A staking purchase response. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseResponse(
		/** The position id. */
		String positionId,
		/** Was the transaction successfull? */
		boolean success) {
}