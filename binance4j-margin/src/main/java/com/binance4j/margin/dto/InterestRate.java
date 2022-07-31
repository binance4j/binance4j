package com.binance4j.margin.dto;

/**
 * A loan interest rate
 * 
 * @param asset             The related coin.
 * @param dailyInterestRate The daily interest rate.
 * @param timestamp         The timestamp of the applied interest rate in ms.
 * @param vipLevel          The account VIP level.
 */
public record InterestRate(String asset, String dailyInterestRate, long timestamp, int vipLevel) {
}