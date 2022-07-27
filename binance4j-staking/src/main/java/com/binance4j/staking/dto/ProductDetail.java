package com.binance4j.staking.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Staking product detail. */
@JsonIgnoreProperties(ignoreUnknown = true)
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
