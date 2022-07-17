package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A deposit address for a given asset. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DepositAddress(
		/** The deposit url. */
		String url,
		/** The deposit address. */
		String address,
		/** The deposit tag. */
		String tag,
		/** The coin abbreviation. */
		String coin) {
}