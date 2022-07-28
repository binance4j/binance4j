package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to get the fees of a trading pair */
@Param
public class TradeFeeParams implements Params {
	/** The trading pair we want the fees. */
	String symbol;

	/** Constructor */
	public TradeFeeParams() {
	}

	/**
	 * @param symbol The symbol.
	 */
	public TradeFeeParams(String symbol) {
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
