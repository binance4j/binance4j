package com.binance4j.wallet.dto;

/**
 * The API trading status detail.
 * 
 * @param isLocked           API trading function is locked or not.
 * @param plannedRecoverTime If API trading function is locked, this is the planned recover time.
 * @param updateTime         The details update timestamps.
 * @param triggerCondition   Trigger condition.
 */
public record ApiTradingStatusData(
		/** API trading function is locked or not. */
		boolean isLocked,
		/** If API trading function is locked, this is the planned recover time. */
		long plannedRecoverTime,
		/** The details update timestamps. */
		long updateTime,
		/** Trigger condition. */
		ApiTradingStatusTriggerCondition triggerCondition) {
}