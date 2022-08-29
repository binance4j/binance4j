package com.binance4j.mining.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * [MiningClient.getAccountProfits] params.
 * 
 * @param algo     Algorithm.
 * @param userName Mining account.
 */
data class AccountListParams(String algo, String userName) : Params {
}