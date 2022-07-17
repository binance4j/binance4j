package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The API trading status detail */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiTradingStatusData(/** API trading function is locked or not. */
boolean isLocked,
		/** If API trading function is locked, this is the planned recover time. */
		long plannedRecoverTime,
		/** The details update timestamps. */
		long updateTime,
		/** Trigger condition. */
		ApiTradingStatusTriggerCondition triggerCondition) {
}