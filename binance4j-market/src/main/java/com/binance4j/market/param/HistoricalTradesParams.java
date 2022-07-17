package com.binance4j.market.param;

import com.binance4j.core.param.Params;

/** The parameters to get the historical trades of a trading pair */
public class HistoricalTradesParams extends Params {
	/** The trading pair to get the trades. */
	private String symbol;
	/** Default 500; max 1000. */
	private Integer limit;
	/** Trade id to fetch from. Default gets most recent trades. */
	private Long fromId;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the trades
	 */
	public HistoricalTradesParams(String symbol) {
		super(5);
		this.symbol = symbol;
	}

	/**
	 * @param symbol The symbol we want the trades
	 * @param limit  The trades size
	 */
	public HistoricalTradesParams(String symbol, int limit) {
		this(symbol);
		this.limit = limit;
	}

	/**
	 * @param symbol The symbol we want the trades
	 * @param limit  The trades size
	 * @param fromId The oldest trade id fro which we want the trades
	 */
	public HistoricalTradesParams(String symbol, long fromId, int limit) {
		this(symbol, limit);
		this.fromId = fromId;
	}

	/**
	 * @param symbol The symbol we want the trades
	 * @param limit  The trades size
	 * @param fromId The oldest trade id fro which we want the trades
	 */
	public HistoricalTradesParams(String symbol, String fromId, int limit) {
		this(symbol, limit);
		this.fromId = Long.getLong(fromId);
	}

	/**
	 * @param symbol The symbol we want the trades
	 * @param fromId The oldest trade id fro which we want the trades
	 */
	public HistoricalTradesParams(String symbol, long fromId) {
		this(symbol);
		this.fromId = fromId;
	}

	/**
	 * @param symbol The symbol we want the trades
	 * @param fromId The oldest trade id fro which we want the trades
	 */
	public HistoricalTradesParams(String symbol, String fromId) {
		this(symbol);
		this.fromId = Long.getLong(fromId);
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the fromId
	 */
	public Long getFromId() {
		return fromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

}
