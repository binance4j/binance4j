package com.binance4j.staking.dto;

/** A staking product. */
public record Product(String projectId, ProductDetail detail, ProductQuota quota) {
}