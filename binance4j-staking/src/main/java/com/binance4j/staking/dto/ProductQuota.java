package com.binance4j.staking.dto;

/**
 * Staking product quota.
 * 
 * @param totalPersonalQuota Total personal quota.
 * @param minimum            Minimum.
 * @param quotaPerOrder      Quota per order.
 */
public record ProductQuota(String totalPersonalQuota, String minimum, String quotaPerOrder) {
}