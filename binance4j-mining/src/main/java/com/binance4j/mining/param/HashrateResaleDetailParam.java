package com.binance4j.mining.param;

import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * {@link MiningClient} params.
 * 
 * @param configId Config id.
 * @param userName User name.
 */
public record HashrateResaleDetailParam(Integer configId, String userName) implements Params {
}