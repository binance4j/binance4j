package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking redeem response.
 * 
 * @property success Success.
 */
@ApiModel("A staking redeem response.")
data class RedeemResponse(@ApiModelProperty("Success.") var success:Boolean?=null)
{
}