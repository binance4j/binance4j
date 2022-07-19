package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An executed trade
 * 
 * @param id              Trade id.
 * @param price           Price.
 * @param quantity        Quantity.
 * @param quoteQuantity   Quote quantity for the trade (price * qty).
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
		long id,
		/** Price. */
		String price,
		/** Quantity. */
		@JsonProperty("qty") String quantity,
		/** Quote quantity for the trade (price * qty). */
		@JsonProperty("quoteQty") String quoteQuantity,
		/** Commission. */
		String commission,
		/** Asset on which commission is taken. */
		String commissionAsset,
		/** Trade execution time. */
		long time,
		/** The symbol of the trade. */
		String symbol,
		/** The order id. */
		String orderId,
		/** Is buyer trade. */
		boolean isBuyer,
		/** Is maker trade. */
		boolean isMaker,
		/** Is best mathc? */
		boolean isBestMatch) {
}