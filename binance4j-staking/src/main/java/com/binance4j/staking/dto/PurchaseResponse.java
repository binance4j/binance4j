package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking purchase response.
 * 
 * @param positionId Position id.
 * @param success    Success.
 */
@ApiModel("")
public record PurchaseResponse(@ApiModelProperty("") String positionId, @ApiModelProperty("") boolean success) {
}