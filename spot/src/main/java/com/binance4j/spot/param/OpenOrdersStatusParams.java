package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * [SpotClient.getOpenOrders] params.
 * 
 * @param symbol Pair we want the open orders.
 */
@Param
data class OpenOrdersStatusParams(String symbol) : Params {

}