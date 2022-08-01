package com.binance4j.wallet.dto;

/**
 * Trading status trigger condition.
 * 
 * @param GCR  Number of GTC orders.
 * @param IFER Number of FOK/IOC orders.
 * @param UFR  Number of FOK/IOC orders.
 */
public record ApiTradingStatusTriggerCondition(long GCR, long IFER, long UFR) {
}
