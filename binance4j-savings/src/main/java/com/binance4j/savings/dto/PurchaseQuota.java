package com.binance4j.savings.dto;

/**
 * Flexible purchase quota.
 * 
 * @param asset     Asset.
 * @param leftQuota Left quota.
 */
public record PurchaseQuota(String asset, String leftQuota) {
}