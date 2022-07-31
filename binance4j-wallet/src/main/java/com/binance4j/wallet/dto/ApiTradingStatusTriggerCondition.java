package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Trading status trigger condition.
 * 
 * @param gcr  Number of GTC orders.
 * @param ifer Number of FOK/IOC orders.
 * @param ufr  Number of FOK/IOC orders.
 */
public record ApiTradingStatusTriggerCondition(@JsonProperty("GCR") long gcr, @JsonProperty("IFER") long ifer, @JsonProperty("UFR") long ufr) {
}
