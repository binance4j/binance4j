package com.binance4j.staking.dto;

/** Staking record. */
public record StakingRecord(String positionId, String time, String asset, String project, String amount, String lockPeriod, String deliverDate, String type,
		String status) {
}
