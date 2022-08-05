package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * {@link SpotClient#getAllOCO} params.
 *
 * @param fromId The id to search from.
 */
@Param(weight = 10)
public record AllOCOInfoParams(Long fromId) implements Params {

}