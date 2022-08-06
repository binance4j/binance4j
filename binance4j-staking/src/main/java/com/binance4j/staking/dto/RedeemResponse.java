package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A staking redeem response.
 * 
 * @param success Success.
 */
@ApiModel("")
public record RedeemResponse(@ApiModelProperty("") boolean success) {
}