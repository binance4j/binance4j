package com.binance4j.rebate.dto;

import com.binance4j.rebate.client.RebateClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link RebateClient#getSpotRebateHistoryRecords} response.
 * 
 * @param status The status.
 * @param type   The type.
 * @param code   The code.
 * @param data   The data.
 */
@ApiModel("")
public record SpotRebateHistoryResponse(@ApiModelProperty("") String status, @ApiModelProperty("") String type, @ApiModelProperty("") String code,
		@ApiModelProperty("") RebateData data) {
}
