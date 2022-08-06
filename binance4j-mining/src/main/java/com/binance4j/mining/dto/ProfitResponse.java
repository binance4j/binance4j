package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link MiningClient#getProfits} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("Profits wrapper.")
public record ProfitResponse(@ApiModelProperty("Response code.") int code, @ApiModelProperty("Response message.") String msg,
		@ApiModelProperty("Response data.") ProfitsData data) {
}