package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getPriceIndex} params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 10)
public record PriceIndexParams(@Mandatory String symbol) implements Params {
}