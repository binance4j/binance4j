package com.binance4j.market.dto;

import io.swagger.annotations.ApiModelProperty;

/** The order book result size */
public enum OrderBookLimit {
	/** 5 */
	LIMIT_5("5"), @ApiModelProperty("")
	/** 10 */
	LIMIT_10("10"), @ApiModelProperty("")
	/** 20 */
	LIMIT_20("20"), @ApiModelProperty("")
	/** 50 */
	LIMIT_50("50"), @ApiModelProperty("")
	/** 100 */
	LIMIT_100("100"), @ApiModelProperty("")
	/** 500 */
	LIMIT_500("500"), @ApiModelProperty("")
	/** 1000 */
	LIMIT_1000("1000"), @ApiModelProperty("")
	/** 5000 */
	LIMIT_5000("5000");

	final String value;

	/**
	 * @param value The value
	 */
	private OrderBookLimit(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}