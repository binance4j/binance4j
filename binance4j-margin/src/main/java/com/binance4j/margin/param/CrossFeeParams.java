package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getMarginFeeData} params.
 * 
 * @param coin     Related coin.
 * @param vipLevel Related VIP level.
 */
@Param(weight = 5)
public record CrossFeeParams(String coin, Integer vipLevel) implements Params {
	/**
	 * Creates an instance of {@link CrossFeeParams}
	 * 
	 * @param coin     Related coin.
	 * @param vipLevel Related VIP level.
	 */
	public CrossFeeParams(String coin, Integer vipLevel) {
		this.coin = coin;
		this.vipLevel = vipLevel;
	}

	/**
	 * Creates an instance of {@link CrossFeeParams}
	 * 
	 * @param coin Related coin.
	 */
	public CrossFeeParams(String coin) {
		this(coin, null);
	}

	/**
	 * Creates an instance of {@link CrossFeeParams}
	 * 
	 * @param vipLevel Related VIP level.
	 */
	public CrossFeeParams(Integer vipLevel) {
		this(null, vipLevel);
	}
}