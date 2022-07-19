package com.binance4j.websocket.param;

public class KeepAliveIsolatedUserDataStreamParams extends IsolatedUserDataStreamParams {
	private String listenKey;

	public KeepAliveIsolatedUserDataStreamParams(String symbol, String listenKey) {
		super(symbol);
		this.listenKey = listenKey;
	}

	/**
	 * @return the listenKey
	 */
	public String getListenKey() {
		return listenKey;
	}

	/**
	 * @param listenKey the listenKey to set
	 */
	public void setListenKey(String listenKey) {
		this.listenKey = listenKey;
	}
}