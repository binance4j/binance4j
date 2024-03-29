package com.binance4j.pay.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.pay.client.PayClient;

/** {@link PayClient#getTrades} params. */
@Param(weight = 3000, type = RateLimitType.UID)
public record TradeHistoryParams() implements Params {
}