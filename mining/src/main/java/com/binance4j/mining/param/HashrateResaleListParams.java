package com.binance4j.mining.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * {@link MiningClient} params.
 */
@Param(weight = 5)
public record HashrateResaleListParams() implements Params {
}
