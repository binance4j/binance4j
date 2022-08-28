package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated account api trading status detail.
 * 
 * @param data Trading status data.
 */
@ApiModel("The authenticated account api trading status detail.")
public record ApiTradingStatus(@ApiModelProperty("Trading status data.") ApiTradingStatusData data) {
}