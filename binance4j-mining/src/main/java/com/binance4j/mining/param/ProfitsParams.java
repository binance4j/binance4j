package com.binance4j.mining.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * {@link MiningClient#getProfits} params.
 * 
 * @param algo     Transfer algorithm.
 * @param userName Mining account test.
 * @param coin     Coin name.
 */
@Param(weight = 5)
public record ProfitsParams(String algo, String userName, String coin) implements Params {
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