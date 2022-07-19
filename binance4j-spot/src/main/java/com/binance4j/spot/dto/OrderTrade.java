package com.binance4j.spot.dto;

import java.math.BigDecimal;

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
		BigDecimal price,
		/** The quantity. */
		BigDecimal quantity,
		/** The commission. */
		BigDecimal commission,
		/** The commission asset. */
		String commissionAsset,
		/** The trade id. */
		long tradeId) {
}
