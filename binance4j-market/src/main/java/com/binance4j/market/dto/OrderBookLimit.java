package com.binance4j.market.dto;

/** The order book result size */
public enum OrderBookLimit {
	/** 5 */
	LIMIT_5("5"),
	/** 10 */
	LIMIT_10("10"),
	/** 20 */
	LIMIT_20("20"),
	/** 50 */
	LIMIT_50("50"),
	/** 100 */
	LIMIT_100("100"),
	/** 500 */
	LIMIT_500("500"),
	/** 1000 */
	LIMIT_1000("1000"),
	/** 5000 */
	LIMIT_5000("5000");

	final String value;

	/**
	 * @param value The value
	 */
	private OrderBookLimit(String value) {
		this.value = value;
	}
}