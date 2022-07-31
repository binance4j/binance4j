package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getAveragePrice} params.
 * 
 * @param symbol The trading pair we want the price.
 */
@Param(recvWindow = false, timestamp = false)
public record AveragePriceParams(@Mandatory String symbol) implements Params {
}