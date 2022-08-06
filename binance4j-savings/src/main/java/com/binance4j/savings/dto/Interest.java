package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lending interest.
 * 
 * @param asset       Asset.
 * @param interest    Interest.
 * @param lendingType LendingType.
 * @param productName ProductName.
 * @param time        Time in ms.
 */
@ApiModel("Lending interest.")
public record Interest(@ApiModelProperty("Asset.") String asset, @ApiModelProperty("Interest.") String interest,
		@ApiModelProperty("LendingType.") String lendingType, @ApiModelProperty("ProductName.") String productName,
		@ApiModelProperty("Time in ms.") long time) {
}