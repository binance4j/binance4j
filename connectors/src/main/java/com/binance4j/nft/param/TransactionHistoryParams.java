package com.binance4j.nft.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.OrderType;

/**
 * [NFTClient.getTransactions] params.
 * 
 * @param orderType Order type.
 */
@Param(weight = 3000, type = RateLimitType.UID)
data class TransactionHistoryParams(
String orderType):Params
{

	/**
	 * @param orderType Order type.
	 */
	public TransactionHistoryParams(OrderType orderType) {
		this(orderType.toString());
	}
}