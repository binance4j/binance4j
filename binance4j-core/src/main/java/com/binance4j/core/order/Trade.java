package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	 * The order id
	 */
	private String orderId;
	/**
	 * is buyer trade
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBuyer;
	/**
	 * is maker trade
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isMaker;
	/**
	 * ???
	 */
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Boolean isBestMatch;

	public Boolean isBestMatch() {
		return isBestMatch;
	}

	public void isBestMatch(boolean isBestMatch) {
		this.isBestMatch = isBestMatch;
	}

	public Boolean isBuyer() {
		return isBuyer;
	}

	public void isBuyer(boolean isBuyer) {
		this.isBuyer = isBuyer;
	}

	public Boolean isMaker() {
		return isMaker;
	}

	public void isMaker(boolean isMaker) {
		this.isMaker = isMaker;
	}
}