package com.binance4j.staking.dto;

/** Staking product detail. */
public record ProductDetail(
		/** Lock up asset. */
		String asset,
		/** Earn Asset. */
		String rewardAsset,
		/** Lock period(days). */
		int duration,
		/** Project supports renewal. */
		boolean renewable,
		/** APY. */
		String apy) {

}
