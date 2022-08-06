package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking redeem response.
 * 
 * @param success Success.
 */
@ApiModel("A staking redeem response.")
public record RedeemResponse(@ApiModelProperty("Success.") boolean success) {
}