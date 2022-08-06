package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The {@link MiningClient#getAccountProfits} response.
 * 
 * @param code The response code.
 * @param msg  The response message.
 * @param data The response data.
 */
@ApiModel("")
public record AccountProfitsResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") AccountProfitsData data) {
}