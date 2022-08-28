package com.binance4j.spot.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.spot.client.SpotClient;

/**
 * [SpotClient.getAllOCO] params.
 *
 * @param fromId Id to search from.
 */
@Param
data class AllOCOInfoParams(Long fromId) : Params {

}