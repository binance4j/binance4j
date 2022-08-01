package com.binance4j.mining.dto;

/**
 * Account profit.
 * 
 * @param time     Time in ms.
 * @param coinName Coin.
 * @param type     0:Referral 1：Refund 2：Rebate.
 * @param puid     Sub-account id.
 * @param subName  Mining account.
 * @param amount   Amount.
 */
public record AccountProfit(long time, String coinName, int type, int puid, String subName, String amount) {
}
