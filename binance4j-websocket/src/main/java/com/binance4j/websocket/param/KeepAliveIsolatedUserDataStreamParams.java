package com.binance4j.websocket.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.websocket.client.UserDataClient;

/** {@link UserDataClient#keepAliveIsolatedUserDataStream} params. */
public class KeepAliveIsolatedUserDataStreamParams extends IsolatedUserDataStreamParams {
	/** The listen key */
	@Mandatory
	String listenKey;

	/**
	 * @param symbol    The symbol.
	 * @param listenKey The listenKey.
	 */
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