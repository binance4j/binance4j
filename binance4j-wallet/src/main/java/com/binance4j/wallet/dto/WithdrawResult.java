package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The result of a withdraw */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WithdrawResult(
		/** The withdraw id. */
		String id) {
}