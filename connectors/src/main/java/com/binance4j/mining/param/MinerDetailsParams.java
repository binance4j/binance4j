package com.binance4j.mining.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * [MiningClient.getMinersDetails] params.
 * 
 * @param algo       Algorithm.
 * @param userName   Mining account.
 * @param workerName Miner’s name.
 */
@Param
data class MinerDetailsParams(String algo, String userName, String workerName) : Params {
}
