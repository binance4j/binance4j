package com.binance4j.websocket.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * An aggregated trade event for a symbol.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggTradePayload {
	/**
	 * The agg trade id
	 */
	@JsonProperty("a")
	private Long aggregatedTradeId;
	/**
	 * The price
	 */
	@JsonProperty("p")
	private String price;
	/**
	 * The volume
	 */
	@JsonProperty("q")
	private String quantity;
	/**
	 * first trade id
	 */
	@JsonProperty("f")
	private Long firstBreakdownTradeId;
	/**
	 * last trade id
	 */
	@JsonProperty("l")
	private Long lastBreakdownTradeId;
	/**
	 * The timestmap
	 */
	@JsonProperty("T")
	private Long tradeTime;
	/**
	 * Was the buyer the maker?
	 */
	@JsonProperty("m")
	private Boolean isBuyerMaker;
	/**
	 * The event type
	 */
	@JsonProperty("e")
	private String eventType;
	/**
	 * The timestamp
	 */
	@JsonProperty("E")
	private Long eventTime;
	/**
	 * The trading pair
	 */
	@JsonProperty("s")
	private String symbol;
}