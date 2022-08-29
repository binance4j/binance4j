package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * [SpotClient.cancelOpenOrders] params.
 * 
 * @param symbol Trade symbol.
 */
data class CancelOpenOrdersParams(String symbol) : Params {
}