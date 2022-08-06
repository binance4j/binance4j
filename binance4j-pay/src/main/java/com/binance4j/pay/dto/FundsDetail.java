package com.binance4j.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Funds detail.
 * 
 * @param currency The asset.
 * @param amount   The amount.
 */
@ApiModel("")
public record FundsDetail(@ApiModelProperty("") String currency, @ApiModelProperty("") String amount) {
}
