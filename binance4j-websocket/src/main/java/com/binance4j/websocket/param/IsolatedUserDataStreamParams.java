package com.binance4j.websocket.param;

import com.binance4j.core.param.Params;

public class IsolatedUserDataStreamParams extends Params {
	private String symbol;

	public IsolatedUserDataStreamParams(String symbol) {
		super(1);
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
