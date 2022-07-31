package com.binance4j.mining.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * {@link MiningClient#getAccountProfits} params.
 * 
 * @param algo Transfer algorithm.
 */
@Param(weight = 5)
public record AccountProfitsParams(@Mandatory String algo) implements Params {
}