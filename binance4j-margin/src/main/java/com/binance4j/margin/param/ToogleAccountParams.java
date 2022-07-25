package com.binance4j.margin.param;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#enableIsolatedAccount},{@link MarginClient#disableIsolatedAccount} params. */
public class ToogleAccountParams extends Params {

	/** The symbol */
	private String symbol;

	/** @param symbol The symbol */
	public ToogleAccountParams(String symbol) {
		super(300);
		rateLimitType = RateLimitType.UID;
		this.symbol = symbol;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
