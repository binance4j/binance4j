package com.binance4j.rebate.dto;

import com.binance4j.rebate.client.RebateClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [RebateClient.getSpotRebateHistoryRecords] response.
 * 
 * @property status Status.
 * @property type   Type.
 * @property code   Code.
 * @property data   Data.
 */
@ApiModel("Rebate history record")
data class SpotRebateHistoryResponse(
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Code.")
@JsonProperty("code") var code:String?=null,
@ApiModelProperty("Data.")
@JsonProperty("data") var data:RebateData?=null)
{
}
