package com.binance4j.savings.dto;

import com.binance4j.savings.client.SavingsClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The {@link SavingsClient#fixedToDailyPosition} response.
 * 
 * @param dailyPurchaseId Daily purchase id.
 * @param success         Success.
 * @param timestamp       Time.
 */
@ApiModel("")
public record PositionChangedResponse(@ApiModelProperty("") long dailyPurchaseId, @ApiModelProperty("") boolean success, @ApiModelProperty("") long timestamp) {
}