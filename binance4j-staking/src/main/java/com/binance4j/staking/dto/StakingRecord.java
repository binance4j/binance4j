package com.binance4j.staking.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Staking record. */
@JsonIgnoreProperties(ignoreUnknown = true)
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
		BigDecimal amount,
		/** Staking lock period. */
		String lockPeriod,
		/** Redemption date. */
		String deliverDate,
		/** Display only for subscription. */
		String type,
		/** Transaction status. */
		String status) {
}
