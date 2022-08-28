package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.LendingType;

/**
 * [SavingsClient.getInterests],
 * [SavingsClient#getPurchases},{@link SavingsClient.getRedemptions]
 * params.
 * 
 * @param lendingType Lending type.
 * @param asset       Asset name.
 */
@Param
data class LendingParams(
LendingType lendingType, String asset):Params
{

	/**
	 * Creates an instance of {@link LendingParams}.
	 * 
	 * @param lendingType Lending type.
	 */
	public LendingParams(LendingType lendingType) {
		this(lendingType, null);
	}
}