package com.binance4j.market.trade;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the historical trades of a trading pair
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
	 *
	 * 
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
}
