package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The {@link MiningClient#getAlgorithms} response.
 * 
 * @param code Response code.
 * @param msg  Response message.
 * @param data Response data.
 */
@ApiModel("")
public record AlgorithmsResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") List<Algorithm> data) {
}