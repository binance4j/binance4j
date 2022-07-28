package com.binance4j.staking.dto;

/** Staking record. */
public record StakingRecord(
		/** Position id. */
		String positionId,
		/** Transaction time in ms. */
		String time,
		/** Asset staked. */
		String asset,
		/** DeFi Staking’s project. */
		String project,
		/** Amount staked. */
		String amount,
		/** Staking lock period. */
		String lockPeriod,
		/** Redemption date. */
		String deliverDate,
		/** Display only for subscription. */
		String type,
		/** Transaction status. */
		String status) {
}
