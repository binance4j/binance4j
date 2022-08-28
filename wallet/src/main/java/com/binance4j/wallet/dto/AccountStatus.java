package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated account status.
 * 
 * @param data Account status.
 */
@ApiModel("The authenticated account status.")
public record AccountStatus(@ApiModelProperty("Account status.") String data) {
}