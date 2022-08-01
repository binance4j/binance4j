package com.binance4j.savings.param;

import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.LendingType;

/**
 * {@link SavingsClient#getInterests}, {@link SavingsClient#getPurchases},{@link SavingsClient#getRedemptions} params.
 * 
 * @param lendingType Lending type.
 * @param asset       Asset name.
 */
public record LendingParams(LendingType lendingType, String asset) implements Params {
	/**
	 * Creates an instance of {@link LendingParams}.
	 * 
	 * @param lendingType Lending type.
	 */
	public LendingParams(LendingType lendingType) {
		this(lendingType, null);
	}
}