package com.binance4j.margin.dto;

import com.binance4j.margin.client.MarginClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BNB burn status after {@link MarginClient#toggleBNBBurnOnSpotTradeAndMarginInterest}
 * 
 * @param spotBNBBurn     Is spot BNB burn allowed.
 * @param interestBNBBurn Is interest BNB burn allowed.
 */
@ApiModel("BNB burn status")
public record BNBBurnStatus(@ApiModelProperty("Is spot BNB burn allowed.") boolean spotBNBBurn,
		@ApiModelProperty("Is interest BNB burn allowed.") boolean interestBNBBurn) {
}