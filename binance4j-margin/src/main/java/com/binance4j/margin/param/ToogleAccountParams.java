package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#enableIsolatedAccount},{@link MarginClient#disableIsolatedAccount} params. */
public class ToogleAccountParams extends FramedParams {
	/** The symbol */
	private String symbol;

	/** @param symbol The symbol */.
	public ToogleAccountParams(String symbol) {
		super(300);
		this.symbol = symbol;
	}

	/** @return the symbol */.
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */.
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
