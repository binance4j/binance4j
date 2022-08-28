package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOrderCount} params.
 */
@Param(weight = 20)
public record OrderCountParams() implements Params {
}