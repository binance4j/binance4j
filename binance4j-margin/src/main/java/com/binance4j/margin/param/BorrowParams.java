package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#borrow} params.
 * 
 * @param asset      Asset to borrow.
 * @param amount     Amount to borrow.
 * @param symbol     Isolated symbol.
 * @param isIsolated For isolated margin or not. Default: false.
 */
@Param(weight = 300, type = RateLimitType.UID)
public record BorrowParams(@Mandatory String asset, @Mandatory String amount, String symbol, Boolean isIsolated) implements Params {
	/**
	 * Creates an instance of {@link BorrowParams}.
	 * 
	 * @param asset  Asset to borrow.
	 * @param amount Amount to borrow.
	 */
	public BorrowParams(String asset, String amount) {
		this(asset, amount, null, null);
	}
}