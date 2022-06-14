package com.binance4j.websocket.payload;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/** Minimal infos Ticker */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniTickerPayload {
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
	 * The close price
	 */
	@JsonProperty("c")
	private BigDecimal closePrice;
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
}