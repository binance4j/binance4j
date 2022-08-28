package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#enableIsolatedAccount},{@link MarginClient#disableIsolatedAccount}
 * params.
 * 
 * @param symbol Max 5 symbols can be sent; separated by ",".
 */
@Param(weight = 300, type = RateLimitType.UID)
public record ToogleAccountParams(String symbol) implements Params {
}