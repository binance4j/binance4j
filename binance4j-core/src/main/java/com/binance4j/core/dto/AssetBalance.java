package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset balance in a wallet.
 * 
 * @param asset  The Asset symbol.
 * @param free   The available balance.
 * @param locked The balance locked by open orders.
 */
@ApiModel("An asset balance in a wallet.")
public record AssetBalance(@ApiModelProperty("The Asset symbol.") String asset, @ApiModelProperty("The available balance.") String free,
		@ApiModelProperty("The balance locked by open orders.") String locked) {
}