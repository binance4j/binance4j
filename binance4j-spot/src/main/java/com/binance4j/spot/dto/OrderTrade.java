package com.binance4j.spot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The partial trade of an order.
 * 
 * @param price           The price.
 * @param quantity        The quantity.
 * @param commission      The commission.
 * @param commissionAsset The commission asset.
 * @param tradeId         The trade id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderTrade(
		/** The price. */
		String price,
		/** The quantity. */
		String quantity,
		/** The commission. */
		String commission,
		/** The commission asset. */
		String commissionAsset,
		/** The trade id. */
		long tradeId) {
}
