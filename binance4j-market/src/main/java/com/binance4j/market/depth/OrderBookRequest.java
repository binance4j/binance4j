package com.binance4j.market.depth;

import com.binance4j.core.request.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A request to get the market depth of a symbol
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderBookRequest extends Request {
	/**
	 * The trading pair we want the depth
	 */
	private String symbol;
	/**
	 * The market depth size
	 */
	private Integer limit;

	/**
	 * Default constructor
	 *
	 * @param symbol The trading pair we want the depth
	 */
	public OrderBookRequest(String symbol) {
		super(1);
		this.symbol = symbol;
	}

	/**
	 * Constructor with limit
	 *
	 * @param symbol The trading pair we want the depth
	 * @param limit  The depth size
	 */
	public OrderBookRequest(String symbol, OrderBookLimit limit) {
		super(getWeight(limit));
		this.symbol = symbol;
		this.limit = limit.getValue();
	}

	/**
	 * Constructor with limit
	 *
	 * @param symbol The trading pair we want the depth
	 * @param limit  The depth size
	 */
	public OrderBookRequest(String symbol, int limit) {
		super(getWeight(limit));
		this.symbol = symbol;
		this.limit = limit;
	}

	/**
	 * Gets the request weight according to the order book limit
	 *
	 * @param limit the depth size
	 * @return the request weight according to the order book limit
	 */
	private static int getWeight(OrderBookLimit limit) {
		switch (limit) {
			case LIMIT_500:
				return 5;
			case LIMIT_1000:
				return 10;
			case LIMIT_5000:
				return 50;
			default:
				return 1;
		}
	}

	/**
	 * Gets the request weight according to the order book limit
	 *
	 * @param limit the depth size
	 * @return the request weight according to the order book limit
	 */
	private static int getWeight(int limit) {
		switch (limit) {
			case 500:
				return 5;
			case 1000:
				return 10;
			case 5000:
				return 50;
			default:
				return 1;
		}
	}
}
