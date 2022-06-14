package com.binance4j.market.tickerstatistics;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 24 hour price change statistics for a ticker.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerStatistics {
	/**
	 * Ticker symbol.
	 */
	private String symbol;
	/**
	 * Price change during the last 24 hours.
	 */
	private BigDecimal priceChange;
	/**
	 * Price change; in percentage; during the last 24 hours.
	 */
	private BigDecimal priceChangePercent;
	/**
	 * Weighted average price.
	 */
	private BigDecimal weightedAvgPrice;
	/**
	 * Previous close price.
	 */
	private BigDecimal prevClosePrice;
	/**
	 * Last price.
	 */
	private BigDecimal lastPrice;
	/**
	 * Last quantity.
	 */
	private BigDecimal lastQty;
	/**
	 * Bid price.
	 */
	private BigDecimal bidPrice;
	/**
	 * Bid quantity.
	 */
	private BigDecimal bidQty;
	/**
	 * Ask price.
	 */
	private BigDecimal askPrice;
	/**
	 * Ask quantity.
	 */
	private BigDecimal askQty;
	/**
	 * Open price 24 hours ago.
	 */
	private BigDecimal openPrice;
	/**
	 * Highest price during the past 24 hours.
	 */
	private BigDecimal highPrice;
	/**
	 * Lowest price during the past 24 hours.
	 */
	private BigDecimal lowPrice;
	/**
	 * Total volume during the past 24 hours.
	 */
	private BigDecimal volume;
	/**
	 * Total quote volume during the past 24 hours.
	 */
	private BigDecimal quoteVolume;
	/**
	 * Open time.
	 */
	private Long openTime;
	/**
	 * Close time.
	 */
	private Long closeTime;
	/**
	 * First trade id.
	 */
	private Long firstId;
	/**
	 * Last trade id.
	 */
	private Long lastId;
	/**
	 * Total number of trades during the last 24 hours.
	 */
	private Long count;
}
