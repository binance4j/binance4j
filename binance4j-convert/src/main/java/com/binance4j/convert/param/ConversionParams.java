package com.binance4j.convert.param;

import com.binance4j.convert.client.ConvertClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link ConvertClient#getConversions} params.
 */
@Param(weight = 100)
public record ConversionParams() implements Params {
}