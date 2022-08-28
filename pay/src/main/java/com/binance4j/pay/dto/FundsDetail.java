package com.binance4j.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Funds detail.
 * 
 * @param currency Asset.
 * @param amount   Amount.
 */
@ApiModel("Funds detail.")
public record FundsDetail(@ApiModelProperty("Asset.") String currency, @ApiModelProperty("Amount.") String amount) {
}
