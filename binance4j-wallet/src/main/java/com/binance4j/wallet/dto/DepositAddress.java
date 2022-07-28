package com.binance4j.wallet.dto;

/**
 * A deposit address for a given asset.
 * 
 * @param url     The deposit url.
 * @param address The deposit address.
 * @param tag     The deposit tag.
 * @param coin    The coin abbreviation.
 */
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