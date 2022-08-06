package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated account api trading status detail.
 * 
 * @param data The trading status data.
 */
@ApiModel("")
public record ApiTradingStatus(@ApiModelProperty("") ApiTradingStatusData data) {
}