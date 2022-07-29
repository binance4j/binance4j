package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getOpenOCO} params.
 */
@Param(weight = 3)
public record OpenOCOParams() implements Params {
}