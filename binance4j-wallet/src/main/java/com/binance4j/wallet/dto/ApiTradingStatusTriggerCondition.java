package com.binance4j.wallet.dto;

/**
 * Trading status trigger condition.
 * 
 * @param gcr  Number of GTC orders.
 * @param ifer Number of FOK/IOC orders.
 * @param ufr  Number of FOK/IOC orders.
 */
public record ApiTradingStatusTriggerCondition(long GCR, long IFER, long UFR) {
}
