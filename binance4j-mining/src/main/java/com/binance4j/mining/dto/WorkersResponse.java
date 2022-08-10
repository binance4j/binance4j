package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Workers data wrapper. {@link MiningClient#getMiners} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("Workers data wrapper.")
public record WorkersResponse(@ApiModelProperty("Response code.") int code,
		@ApiModelProperty("Response message.") String msg,
		@ApiModelProperty("Response data.") WorkersData data) {
}