package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getMaxBorrowable} params.
 * 
 * @param asset          Asset.
 * @param isolatedSymbol Symbol.
 */
@Param(weight = 50)
public record MaxBorrowableParams(String asset, String isolatedSymbol) implements Params {
	/**
	 * Creates an instance of {@link MaxBorrowableParams}.
	 * 
	 * @param asset Asset.
	 */
	public MaxBorrowableParams(String asset) {
		this(asset, null);
	}
}