package com.binance4j.websocket.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.websocket.client.UserDataClient;

/** {@link UserDataClient#startIsolatedUserDataStream} params. */
public class IsolatedUserDataStreamParams implements Params {
	/** The symbol */
	@Mandatory
	String symbol;

	/**
	 * @param symbol The symbol.
	 */
	public IsolatedUserDataStreamParams(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
