package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated account status.
 * 
 * @param data The account status.
 */
@ApiModel("")
public record AccountStatus(@ApiModelProperty("") String data) {
}