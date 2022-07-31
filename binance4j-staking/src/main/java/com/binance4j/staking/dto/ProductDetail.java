package com.binance4j.staking.dto;

/** Staking product detail. */
public record ProductDetail(String asset, String rewardAsset, int duration, boolean renewable, String apy) {
}
