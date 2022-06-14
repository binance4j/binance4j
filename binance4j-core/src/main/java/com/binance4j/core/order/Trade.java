package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Represents an executed trade.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade {
	/**
	 * Trade id.
	 */
	private Long id;
	/**
	 * Price.
	 */
	private String price;
	/**
	 * Quantity.
	 */
	private String qty;
	/**
	 * Quote quantity for the trade (price * qty).
	 */
	private String quoteQty;
	/**
	 * Commission.
	 */
	private String commission;
	/**
	 * Asset on which commission is taken
	 */
	private String commissionAsset;
	/**
	 * Trade execution time.
	 */
	private Long time;
	/**
	 * The symbol of the trade.
	 */
	private String symbol;
	/**
	 * is buyer trade
	 */
	private Boolean isBuyer;
	/**
	 * is maker trade
	 */
	private Boolean isMaker;
	/**
	 * ???
	 */
	private Boolean isBestMatch;
	/**
	 * The order id
	 */
	private String orderId;
}