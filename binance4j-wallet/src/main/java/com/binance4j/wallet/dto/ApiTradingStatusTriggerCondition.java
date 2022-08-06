package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trading status trigger condition.
 * 
 * @param GCR  Number of GTC orders.
 * @param IFER Number of FOK/IOC orders.
 * @param UFR  Number of FOK/IOC orders.
 */
@ApiModel("Trading status trigger condition.")
public record ApiTradingStatusTriggerCondition(@ApiModelProperty("Number of GTC orders.") long GCR, @ApiModelProperty("Number of FOK/IOC orders.") long IFER,
		@ApiModelProperty("Number of FOK/IOC orders.") long UFR) {
}
