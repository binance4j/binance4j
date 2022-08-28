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
var dailyPurchaseId:Long?=null,
@ApiModelProperty("Success.")
var success:Boolean?=null,
@ApiModelProperty("Time.") var timestamp:Long?=null)
{
}