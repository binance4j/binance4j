package com.binance4j.core.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The representation of an aggregated trade.
 * 
 * @param tradeId      The trade id
 * @param firstTradeId The first trade id
 * @param lastTradeId  The last trade id
 * @param time         The timestamp
 * @param price        The price
 * @param quantity     The quantity
 * @param isBuyerMaker Was it a buyer maker
 * @param isBestMatch  Was it the best price match?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AggTrade(
		/** The trade id */
		@JsonProperty("a") long tradeId,
		/** The first trade id */
		@JsonProperty("f") long firstTradeId,
		/** The last trade id */
		@JsonProperty("l") long lastTradeId,
		/** The timestamp */
		@JsonProperty("T") long time,
		/** The price */
		@JsonProperty("p") BigDecimal price,
		/** The quantity */
		@JsonProperty("q") BigDecimal quantity,
		/** Was it a buyer maker */
		@JsonProperty("m") boolean isBuyerMaker, /** Was it the best price match? */
		@JsonProperty("M") boolean isBestMatch) {

	public AggTrade(List<String> input) {
		this(Long.parseLong(input.get(0)), Long.parseLong(input.get(3)), Long.parseLong(input.get(4)), Long.parseLong(input.get(5)),
				new BigDecimal(input.get(1)), new BigDecimal(input.get(2)), Boolean.parseBoolean(input.get(6)), Boolean.parseBoolean(input.get(7)));
	}
}