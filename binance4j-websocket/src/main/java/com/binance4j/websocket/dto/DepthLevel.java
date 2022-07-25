package com.binance4j.websocket.dto;

/** The order book size */
public enum DepthLevel {
	/** Depth of 5 results. */
	LEVEL_5("5"),
	/** Depth of 10 results. */
	LEVEL_10("10"),
	/** Depth of 20 results. */
	LEVEL_20("20");

	/** The result size. */
	final String value;

	/**
	 * @param value
	 */
	private DepthLevel(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}