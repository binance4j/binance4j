package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#subscribe} params.
 * 
 * @param tokenName The token name.
 * @param cost      Cost to subscribe to.
 */
@Param
public record SubscriptionParams(String tokenName, String cost) implements Params {
}