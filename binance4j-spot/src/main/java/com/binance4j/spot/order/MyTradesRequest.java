package com.binance4j.spot.order;

import com.binance4j.core.request.IntervalRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get trades for a specific account and symbol.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyTradesRequest extends IntervalRequest {
	/**
	 * The symbol of the trade
	 */
	private String symbol;
	/**
	 * The order id of the trade
	 */
	private Long orderId;
	/**
	 * The id from which we search trades
	 */
	private Long fromId;
	/**
	 * The size of the result. Default 500; max 1000.
	 */
	private Integer limit;

	/**
	 * Default constructor
	 *
	 * @param symbol The symbol we want the trades
	 */
	public MyTradesRequest(String symbol) {
		super(10);
		this.symbol = symbol;
	}

	/**
	 * Constructor
	 *
	 * @param symbol The symbol we want the trades
	 * @param limit  The result size
	 */
	public MyTradesRequest(String symbol, Integer limit) {
		this(symbol);
		this.limit = limit;
	}
}
