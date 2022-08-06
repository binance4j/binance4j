package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The {@link MiningClient} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("")
public record ProfitResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") ProfitsData data) {
}