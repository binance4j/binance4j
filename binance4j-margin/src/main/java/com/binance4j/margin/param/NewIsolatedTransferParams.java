package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTransferAccount;

/**
 * {@link MarginClient#newIsolatedTransfer} params.
 * 
 * @param asset     Asset to transfer.
 * @param symbol    Symbol to transfer from.
 * @param amount    Amount to transfer.
 * @param transFrom Transfer origin.
 * @param transTo   Transfer destination..
 */
@Param(weight = 600, type = RateLimitType.UID)
public record NewIsolatedTransferParams(@Mandatory String asset, @Mandatory String symbol, @Mandatory String amount,
		@Mandatory IsolatedTransferAccount transFrom, @Mandatory IsolatedTransferAccount transTo) implements Params {
}