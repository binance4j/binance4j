package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The result of a withdraw.
 * 
 * @param id Withdraw id.
 */
@ApiModel("The result of a withdraw.")
public record WithdrawResult(@ApiModelProperty("Withdraw id.") String id) {
}