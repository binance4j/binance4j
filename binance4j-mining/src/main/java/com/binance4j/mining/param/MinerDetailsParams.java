package com.binance4j.mining.param;

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
public record MinerDetailsParams(String algo, String userName, String workerName) implements Params {
}
