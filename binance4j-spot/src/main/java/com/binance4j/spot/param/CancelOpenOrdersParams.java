package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#cancelOpenOrders} params.
 * 
 * @param symbol Trade symbol.
 */
@Param
public record CancelOpenOrdersParams(String symbol) implements Params {
}