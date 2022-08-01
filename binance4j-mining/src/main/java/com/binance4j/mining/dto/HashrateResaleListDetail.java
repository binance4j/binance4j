package com.binance4j.mining.dto;

/**
 * @param configId       Mining ID.
 * @param poolUsername   Transfer out of subaccount.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param startDay       Start date.
 * @param endDay         End date.
 * @param status         Status：0 Processing，1：Cancelled，2：Terminated.
 */
public record HashrateResaleListDetail(int configId, String poolUsername, String toPoolUsername, String algoName, long hashRate, long startDay, long endDay,
		int status) {
}
