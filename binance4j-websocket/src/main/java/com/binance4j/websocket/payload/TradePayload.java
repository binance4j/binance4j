package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Pair trade data */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradePayload {
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
	/**
	 * The trade id
	 */
	@JsonProperty("t")
	private String tradeId;
	/**
	 * The price
	 */
	@JsonProperty("p")
	private BigDecimal price;
	/**
	 * The price
	 */
	@JsonProperty("q")
	private BigDecimal quantity;
	/**
	 * The buyer order id
	 */
	@JsonProperty("b")
	private Long buyerOrderId;
	/**
	 * The seller order id
	 */
	@JsonProperty("a")
	private Long sellerOrderId;
	/**
	 * The timestamp
	 */
	@JsonProperty("T")
	private Long tradeTime;
	/**
	 * Is the buyer the market maker?
	 */
	@JsonProperty("m")
	private Boolean buyerIsMarketMaker;
	/**
	 * Ignore
	 */
	@JsonProperty("M")
	private Boolean ignore;
}