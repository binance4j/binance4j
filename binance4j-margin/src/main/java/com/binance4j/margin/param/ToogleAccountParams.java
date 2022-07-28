package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#enableIsolatedAccount},{@link MarginClient#disableIsolatedAccount} params. */
@Param(weight = 300, type = RateLimitType.UID)
public class ToogleAccountParams implements Params {
	/** The symbol */
	@Mandatory
	String symbol;

	/** @param symbol The symbol */
	public ToogleAccountParams(String symbol) {
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
