package com.binance4j.wallet.tradingstatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * The API trading status detail
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiTradingStatusData {
	/**
	 * API trading function is locked or not
	 */
	private Boolean isLocked;
	/**
	 * If API trading function is locked, this is the planned recover time
	 */
	private Long plannedRecoverTime;
	/**
	 * The details update timestamps
	 */
	private Long updateTime;
	/**
	 * Trigger condition
	 */
	private ApiTradingStatusTriggerCondition triggerCondition;
}