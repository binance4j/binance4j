package com.binance4j.spot.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The partial trade of an order */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderTrade(
		/** The price. */
		BigDecimal price,
		/** The quantity. */
		BigDecimal qty,
		/** The commission. */
		BigDecimal commission,
		/** The commission asset. */
		String commissionAsset,
		/** The trade id. */
		long tradeId) {
}
