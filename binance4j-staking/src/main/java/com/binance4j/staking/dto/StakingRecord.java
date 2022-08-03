package com.binance4j.staking.dto;

/**
 * Staking record.
 * 
 * @param positionId  position id.
 * @param time        time.
 * @param asset       asset.
 * @param project     project.
 * @param amount      amount.
 * @param lockPeriod  lock period.
 * @param deliverDate deliver date.
 * @param type        type.
 * @param status      status.
 */
public record StakingRecord(String positionId, String time, String asset, String project, String amount, String lockPeriod, String deliverDate, String type,
		String status) {
}
