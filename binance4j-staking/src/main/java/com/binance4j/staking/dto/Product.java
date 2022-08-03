package com.binance4j.staking.dto;

/**
 * A staking product.
 * 
 * @param projectId Project id.
 * @param detail    Detail.
 * @param quota     Quota.
 */
public record Product(String projectId, ProductDetail detail, ProductQuota quota) {
}