package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModelProperty;

/** The NFT order type */
public enum OrderType {
	/** Purchase order */
	PURCHASE_ORDER("0"), @ApiModelProperty("")
	/** Sell order */
	SELL_ORDER("1"), @ApiModelProperty("")
	/** Royalty income */
	ROYALTY_INCOME("2"), @ApiModelProperty("")
	/** Primary market_order */
	PRIMARY_MARKET_ORDER("3"), @ApiModelProperty("")
	/** Mint fee */
	MINT_FEE("4");

	/**
	 * @param value The value.
	 */
	private OrderType(String value) {
		this.value = value;
	}

	/** The error code. */
	final String value;

	@Override
	public String toString() {
		return value;
	}
}
