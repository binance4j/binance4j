package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link MiningClient#getAccountProfits} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("Account profits wrapper.")
public record AccountProfitsResponse(@ApiModelProperty("Response code.") int code, @ApiModelProperty("Response message.") String msg,
		@ApiModelProperty("Response data.") AccountProfitsData data) {
}