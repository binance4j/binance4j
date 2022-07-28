package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getCrossMarginPair} params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 10)
public record PairParams(@Mandatory String symbol) implements Params {
}