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
@ApiModel("")
public record ApiTradingStatusTriggerCondition(@ApiModelProperty("") long GCR, @ApiModelProperty("") long IFER, @ApiModelProperty("") long UFR) {
}
