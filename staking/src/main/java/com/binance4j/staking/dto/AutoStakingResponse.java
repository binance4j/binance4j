package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auto staking response.
 * 
 * @property success Success.
 */
@ApiModel("Auto staking response.")
data class AutoStakingResponse(@ApiModelProperty("Success.") var success:Boolean?=null)
{
}