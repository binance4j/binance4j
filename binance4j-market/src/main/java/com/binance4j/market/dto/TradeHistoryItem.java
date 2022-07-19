package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an executed trade history item.
 * 
 * @param id            The trade id.
 * @param price         The trad price.
 * @param quantity      The trade volume.
 * @param quoteQuantity The trade opposite volume.
 * @param time          The trade execution in ms.
 * @param isBuyerMaker  Is the trade a buyer maker trade.
 * @param isBestMatch   Was the trade the best price match?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TradeHistoryItem(
		/** The trade id. */
		long id,
		/** The trad price. */
		String price,
		/** The trade volume. */
		@JsonProperty("qty") String quantity,
		/** The trade opposite volume. */
		@JsonProperty("quoteQty") String quoteQuantity,
		/** The trade execution in ms. */
		long time,
		/** Is the trade a buyer maker trade. */
		boolean isBuyerMaker,
		/** Was the trade the best price match? */
		boolean isBestMatch) {
}
