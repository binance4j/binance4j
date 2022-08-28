package com.binance4j.rebate.dto;

import com.binance4j.rebate.client.RebateClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link RebateClient#getSpotRebateHistoryRecords} response.
 * 
 * @param status Status.
 * @param type   Type.
 * @param code   Code.
 * @param data   Data.
 */
@ApiModel("Rebate history record")
public record SpotRebateHistoryResponse(@ApiModelProperty("Status.") String status,
		@ApiModelProperty("Type.") String type,
		@ApiModelProperty("Code.") String code, @ApiModelProperty("Data.") RebateData data) {
}
