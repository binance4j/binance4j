package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#transfer} params.
 * 
 * @param asset  Asset being transferred.
 * @param amount Amount to be transferred.
 * @param type   Transfer type.
 */
@Param(weight = 600, type = RateLimitType.UID)
public record TransferParams(@Mandatory String asset, @Mandatory String amount, @Mandatory Integer type) implements Params {
}