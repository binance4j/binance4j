package com.binance4j.mining.dto;

/**
 * @param poolUsername   Transfer out of sub-account.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param day            Transfer date.
 * @param amount         Transferred income.
 * @param coinName       Coin Name.
 */
public record HashrateResaleDetail(String poolUsername, String toPoolUsername, String algoName, long hashRate, long day, String amount, String coinName) {
}
