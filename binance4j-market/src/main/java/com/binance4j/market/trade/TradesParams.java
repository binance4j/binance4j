package com.binance4j.market.trade;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get recent trades
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradesParams extends Params {
	/**
	 * The symbol we want the trades
	 */
	private String symbol;
	/**
	 * The trades size. Default 500; max 1000.
	 */
	private Integer limit = 500;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the trades
	 */
	public TradesParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * Constructor
	 *
	 * @param symbol The symbol we want the trades
	 * @param limit  The trades size. Default 500; max 1000.
	 */
	public TradesParams(String symbol, int limit) {
		this(symbol);
		this.limit = limit;
	}
}
