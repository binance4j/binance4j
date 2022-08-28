package com.binance4j.websocket.dto;

/** The order book update speed. */
public enum DepthUpdateSpeed {
	/** Update of 1000ms. */
	MS_1000("1000ms"),
	/** Update of 100ms. */
	MS_100("100ms");

	/** The result update speed. */
	final String value;

	/**
	 * @property value Value
	 */
	private DepthUpdateSpeed(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
