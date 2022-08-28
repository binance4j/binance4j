package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auto staking response.
 * 
 * @param success Success.
 */
@ApiModel("Auto staking response.")
public record AutoStakingResponse(@ApiModelProperty("Success.") boolean success) {
}