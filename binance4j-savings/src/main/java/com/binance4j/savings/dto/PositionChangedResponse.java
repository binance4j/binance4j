package com.binance4j.savings.dto;

import com.binance4j.savings.client.SavingsClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link SavingsClient#fixedToDailyPosition} response.
 * 
 * @param dailyPurchaseId Daily purchase id.
 * @param success         Success.
 * @param timestamp       Time.
 */
@ApiModel("Response for changing fixed product to flexible.")
public record PositionChangedResponse(@ApiModelProperty("Daily purchase id.") long dailyPurchaseId,
		@ApiModelProperty("Success.") boolean success,
		@ApiModelProperty("Time.") long timestamp) {
}