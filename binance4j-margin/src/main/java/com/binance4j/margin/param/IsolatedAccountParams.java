package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getIsolatedAccount} params.
 * 
 * @param symbols Max 5 symbols can be sent; separated by ",".
 */
@Param(weight = 10)
public record IsolatedAccountParams(String symbols) implements Params {
	/** Creates an instance of {@link IsolatedAccountParams}. */
	public IsolatedAccountParams() {
		this(null);
	}
}