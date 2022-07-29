package com.binance4j.mining.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * @param algo     Transfer algorithm.
 * @param userName Mining account test.
 * @param coin     Coin name.
 */
@Param(weight = 5)
public record ProfitsParams(@Mandatory String algo, @Mandatory String userName, String coin) implements Params {
	/**
	 * Creates an instance of {@link ProfitsParams}.
	 * 
	 * @param algo     Transfer algorithm.
	 * @param userName Mining account test.
	 */
	public ProfitsParams(String algo, String userName) {
		this(algo, userName, null);
	}
}