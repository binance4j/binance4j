package com.binance4j.nft.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.OrderType;

/**
 * {@link NFTClient#getTransactions} params.
 * 
 * @param orderType The order type.
 */
@Param(weight = 3000, type = RateLimitType.UID)
public record TransactionHistoryParams(String orderType) implements Params {
	/**
	 * @param orderType The order type.
	 */
	public TransactionHistoryParams(OrderType orderType) {
		this(orderType.toString());
	}
}