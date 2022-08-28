package com.binance4j.mining.param;

import com.binance4j.core.param.Params;
import com.binance4j.mining.client.MiningClient;

/**
 * [MiningClient.resellHashrate] params.
 * 
 * @param userName   Mining Account test.
 * @param algo       Transfer algorithm.
 * @param endDate    Resale End Time in ms.
 * @param startDate  Resale Start Time in ms.
 * @param toPoolUser Mining Account.
 * @param hashRate   Resale hashrate h/s must be transferred (BTC is greater
 *                   than 500000000000 ETH is greater than
 *                   500000).
 */
data

class HashrateResaleParams(String userName, String algo, Long startDate, Long endDate, String toPoolUser,
		Long hashRate) : Params {
}
