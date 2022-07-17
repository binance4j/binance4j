package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An executed trade
 * 
 * @param id              Trade id.
 * @param price           Price.
 * @param qty             Quantity.
 * @param quoteQty        Quote quantity for the trade (price * qty).
 * @param commission      Commission.
 * @param commissionAsset Asset on which commission is taken.
 * @param time            Trade execution time.
 * @param symbol          The symbol of the trade.
 * @param orderId         The order id.
 * @param isBuyer         Is buyer trade.
 * @param isMaker         Is maker trade.
 * @param isBestMatch     Is best match?
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
		/** Asset on which commission is taken. */
		String commissionAsset,
		/** Trade execution time. */
		Long time,
		/** The symbol of the trade. */
		String symbol,
		/** The order id. */
		String orderId,
		/** Is buyer trade. */
		Boolean isBuyer,
		/** Is maker trade. */
		Boolean isMaker,
		/** Is best mathc? */
		Boolean isBestMatch) {
}