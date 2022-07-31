package com.binance4j.mining.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * {@link MiningClient#getMinersDetails} params.
 * 
 * @param algo       Algorithm.
 * @param userName   Mining account.
 * @param workerName Miner’s name.
 */
@Param(weight = 5)
public record MinerDetailsParams(@Mandatory String algo, @Mandatory String userName, @Mandatory String workerName) implements Params {
}
