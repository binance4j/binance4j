package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link MiningClient#resellHashrate} response.
 * 
 * @param code Code.
 * @param msg  Message.
 * @param data Mining account.
 */
@ApiModel("Hashrate resale wrapper")
public record HashrateResaleResponse(@ApiModelProperty("Code.") int code, @ApiModelProperty("Message.") String msg,
		@ApiModelProperty("Mining account.") int data) {
}
