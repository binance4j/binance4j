package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The {@link MiningClient} response.
 * 
 * @param code The response code.
 * @param msg  The response message.
 * @param data The response data.
 */
@ApiModel("")
public record AccountListResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") List<AccountData> data) {
}