package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Pair ticker */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerPayload {
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
	 * The price change
	 */
	@JsonProperty("p")
	private BigDecimal priceChange;
	/**
	 * The price change percent
	 */
	@JsonProperty("P")
	private BigDecimal priceChangePercent;
	/**
	 * The waighted average price
	 */
	@JsonProperty("w")
	private BigDecimal weightedAveragePrice;
	/**
	 * The previous days close price
	 */
	@JsonProperty("x")
	private BigDecimal previousDaysClosePrice;
	/**
	 * The current days close price
	 */
	@JsonProperty("c")
	private BigDecimal currentDaysClosePrice;
	/**
	 * Last quantity
	 */
	@JsonProperty("Q")
	private BigDecimal closeTradesQuantity;
	/**
	 * Best bid price
	 */
	@JsonProperty("b")
	private BigDecimal bestBidPrice;
	/**
	 * Best bid quantity
	 */
	@JsonProperty("B")
	private BigDecimal bestBidQuantity;
	/**
	 * Best ask price
	 */
	@JsonProperty("a")
	private BigDecimal bestAskPrice;
	/**
	 * Best ask quantity
	 */
	@JsonProperty("A")
	private BigDecimal bestAskQuantity;
	/**
	 * The open price
	 */
	@JsonProperty("o")
	private BigDecimal openPrice;
	/**
	 * The highest price
	 */
	@JsonProperty("h")
	private BigDecimal highPrice;
	/**
	 * The lowest price
	 */
	@JsonProperty("l")
	private BigDecimal lowPrice;
	/**
	 * Total traded base asset volume
	 */
	@JsonProperty("v")
	private BigDecimal totalTradedBaseAssetVolume;
	/**
	 * Total traded quote asset volume
	 */
	@JsonProperty("q")
	private BigDecimal totalTradedQuoteAssetVolume;
	/**
	 * Statistics open time
	 */
	@JsonProperty("O")
	private Long statisticsOpenTime;
	/**
	 * Statistics close time
	 */
	@JsonProperty("C")
	private Long statisticsCloseTime;
	/**
	 * First trade ID
	 */
	@JsonProperty("F")
	private Long firstTradeId;
	/**
	 * Last trade Id
	 */
	@JsonProperty("L")
	private Long lastTradeId;
	/**
	 * Total number of trades
	 */
	@JsonProperty("n")
	private Long totalNumberOfTrades;
}