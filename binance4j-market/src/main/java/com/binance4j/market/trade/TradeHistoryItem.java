package com.binance4j.market.trade;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents an executed trade history item.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeHistoryItem {
	/**
	 * The trade id
	 */
	private Long id;
	/**
	 * The trad price
	 */
	private String price;
	/**
	 * The trade volume
	 */
	@JsonProperty("qty")
	private String quantity;
	/**
	 * The trade opposite volume
	 */
	@JsonProperty("quoteQty")
	private String quoteQuantity;
	/**
	 * The trade execution in ms
	 */
	private Long time;
	/**
	 * Is the trade a buyer maker trade
	 */
	private Boolean isBuyerMaker;
	/**
	 * Was the trade the best price match?
	 */
	private Boolean isBestMatch;
}
