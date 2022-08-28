package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking purchase response.
 * 
 * @property positionId Position id.
 * @property success    Success.
 */
@ApiModel("A staking purchase response.")
data class PurchaseResponse(
@ApiModelProperty("Position id.")
@JsonProperty("positionId") var positionId:String?=null,
@ApiModelProperty("Success.") @JsonProperty("success") var success:Boolean?=null)
{
}