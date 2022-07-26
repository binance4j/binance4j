package com.binance4j.websocket.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Pair trade data.
 * 
 * @param eventType          The event type.
 * @param eventTime          The timestamp.
 * @param symbol             The trading pair.
 * @param tradeId            The trade id.
 * @param price              The price.
 * @param quantity           The price.
 * @param buyerOrderId       The buyer order id.
 * @param sellerOrderId      The seller order id.
 * @param tradeTime          The timestamp.
 * @param buyerIsMarketMaker Is the buyer the market maker?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Trade(
		/** The event type. */
		@JsonProperty("e") String eventType,
		/** The timestamp. */
		@JsonProperty("E") Long eventTime,
		/** The trading pair. */
		@JsonProperty("s") String symbol,
		/** The trade id. */
		@JsonProperty("t") String tradeId,
		/** The price. */
		@JsonProperty("p") BigDecimal price,
		/** The price. */
		@JsonProperty("q") BigDecimal quantity,
		/** The buyer order id. */
		@JsonProperty("b") Long buyerOrderId,
		/** The seller order id. */
		@JsonProperty("a") Long sellerOrderId,
		/** The timestamp. */
		@JsonProperty("T") Long tradeTime,
		/** Is the buyer the market maker? */
		@JsonProperty("m") Boolean buyerIsMarketMaker) {
}