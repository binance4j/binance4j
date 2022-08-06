package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auto staking response.
 * 
 * @param success Success.
 */
@ApiModel("")
public record AutoStakingResponse(@ApiModelProperty("") boolean success) {
}