package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Max transferable amount.
 * 
 * @param amount Max transferable amount.
 */
@ApiModel("Max transferable amount.")
public record MaxTransferable(@ApiModelProperty("Max transferable amount.") String amount) {
}