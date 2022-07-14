package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents an executed trade.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Trade(
		/** Trade id. */
		Long id,
		/** Price. */
		String price,
		/** Quantity. */
		String qty,
		/** Quote quantity for the trade (price * qty). */
		String quoteQty,
		/** Commission. */
		String commission,
		/** Asset on which commission is taken */
		String commissionAsset,
		/** Trade execution time. */
		Long time,
		/** The symbol of the trade. */
		String symbol,
		/** The order id */
		String orderId,
		/** is buyer trade */
		Boolean isBuyer,
		/** is maker trade */
		Boolean isMaker,
		/** ??? */
		Boolean isBestMatch) {
}