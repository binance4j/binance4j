package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#repay} params.
 * 
 * @param asset      Asset to repay.
 * @param amount     Amount to repay.
 * @param symbol     Isolated symbol.
 * @param isIsolated For isolated margin or not. Default {@code false}.
 */
@Param(weight = 300, type = RateLimitType.UID)
public record RepayParams(@Mandatory String asset, @Mandatory String amount, String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link RepayParams}.
	 * 
	 * @param asset  Asset to repay.
	 * @param amount Amount to repay.
	 */
	public RepayParams(String asset, String amount) {
		this(asset, amount, null, null);
	}

	/**
	 * Creates an instance of {@link RepayParams}.
	 * 
	 * @param asset  Asset to repay.
	 * @param amount Amount to repay.
	 * @param symbol Isolated symbol. {@code isIsolated} set to true.
	 */
	public RepayParams(String asset, String amount, String symbol) {
		this(asset, amount, symbol, true);
	}
}