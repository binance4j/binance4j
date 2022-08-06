package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The result of a withdraw.
 * 
 * @param id The withdraw id.
 */
@ApiModel("")
public record WithdrawResult(@ApiModelProperty("") String id) {
}