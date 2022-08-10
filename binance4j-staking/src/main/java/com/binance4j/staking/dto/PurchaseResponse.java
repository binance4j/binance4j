package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking purchase response.
 * 
 * @param positionId Position id.
 * @param success    Success.
 */
@ApiModel("A staking purchase response.")
public record PurchaseResponse(@ApiModelProperty("Position id.") String positionId,
		@ApiModelProperty("Success.") boolean success) {
}