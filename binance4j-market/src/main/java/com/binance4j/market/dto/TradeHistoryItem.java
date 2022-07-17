package com.binance4j.market.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents an executed trade history item. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TradeHistoryItem(
		/** The trade id. */
		Long id,
		/** The trad price. */
		String price,
		/** The trade volume. */
		@JsonProperty("qty") String quantity,
		/** The trade opposite volume. */
		@JsonProperty("quoteQty") String quoteQuantity,
		/** The trade execution in ms. */
		Long time,
		/** Is the trade a buyer maker trade. */
		Boolean isBuyerMaker,
		/** Was the trade the best price match?. */
		Boolean isBestMatch) {
}
