package com.binance4j.nft.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.nft.client.NFTClient;
import com.binance4j.nft.dto.OrderType;

/** {@link NFTClient#getTransactions} params. */
@Param(weight = 3000, type = RateLimitType.UID)
public record TransactionHistoryParams(@Mandatory OrderType orderType) implements Params {
}