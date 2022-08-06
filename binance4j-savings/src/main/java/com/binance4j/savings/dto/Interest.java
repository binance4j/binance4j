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
@ApiModel("")
public record Interest(@ApiModelProperty("") String asset, @ApiModelProperty("") String interest, @ApiModelProperty("") String lendingType,
		@ApiModelProperty("") String productName, @ApiModelProperty("") long time) {
}