package com.binance4j.margin.param;

import com.binance4j.core.param.Params;

/** Request to cancel an order. */
public class CancelOpenOrdersParams extends Params {

	/** The trade symbol */
	String symbol;
	/** for isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
	Boolean isIsolated;

	/**
	 * @param symbol The trade symbol.
	 */
	public CancelOpenOrdersParams(String symbol) {
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

	/**
	 * @return the isIsolated
	 */
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

}