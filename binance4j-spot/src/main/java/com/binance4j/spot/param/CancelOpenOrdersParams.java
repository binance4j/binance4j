package com.binance4j.spot.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** Request to cancel an order. */
@Param
public class CancelOpenOrdersParams implements Params {
	/** The trade symbol */
	@Mandatory
	String symbol;
	/** for isolated margin or not. Default: false. */
	Boolean isIsolated;

	/**
	 * @param symbol The trade symbol.
	 */
	public CancelOpenOrdersParams(String symbol) {
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

	/**
	 * @return the isIsolated
	 */
	public Boolean isIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void isIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

}