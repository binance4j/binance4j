package com.binance4j.websocket.dto;

/** The order book update speed */
public enum DepthUpdateSpeed {

	/** Update of 1000ms. */
	MS_1000("1000ms"),
	/** Update of 100ms. */
	MS_100("100ms");

	/** The result update speed. */
	private final String value;

	/**
	 * @param calue
	 */
	private DepthUpdateSpeed(String calue) {
		this.value = calue;
	}

	@Override
	public String toString() {
		return value;
	}
}
