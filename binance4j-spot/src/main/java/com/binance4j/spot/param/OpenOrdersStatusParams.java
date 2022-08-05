package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOpenOrders} params.
 * 
 * @param symbol The pair we want the open orders.
 */
@Param(weight = 40)
public record OpenOrdersStatusParams(String symbol) implements Params {

}