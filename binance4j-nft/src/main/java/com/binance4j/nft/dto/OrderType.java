package com.binance4j.nft.dto;

/** The NFT order type */
public enum OrderType {
	/** Purchase order */
	PURCHASE_ORDER("0"),
	/** Sell order */
	SELL_ORDER("1"),
	/** Royalty income */
	ROYALTY_INCOME("2"),
	/** Primary market_order */
	PRIMARY_MARKET_ORDER("3"),
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
