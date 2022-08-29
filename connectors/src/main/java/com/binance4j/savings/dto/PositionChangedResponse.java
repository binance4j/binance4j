package com.binance4j.savings.dto;

import com.binance4j.savings.client.SavingsClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [SavingsClient.fixedToDailyPosition] response.
 * 
 * @property dailyPurchaseId Daily purchase id.
 * @property success         Success.
 * @property timestamp       Time.
 */
@ApiModel("Response for changing fixed product to flexible.")
data class PositionChangedResponse(
@ApiModelProperty("Daily purchase id.")
@JsonProperty("dailyPurchaseId") var dailyPurchaseId: Long = 0L,
@ApiModelProperty("Success.")
@JsonProperty("success") var success: Boolean = false,
@ApiModelProperty("Time.") @JsonProperty("timestamp") var timestamp: Long = 0L)
{
}