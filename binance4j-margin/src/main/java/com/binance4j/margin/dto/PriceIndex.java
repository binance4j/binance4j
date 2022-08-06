package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A symbol price index.
 * 
 * @param calcTime Last price calculation timestamp in ms.
 * @param price    Price.
 * @param symbol   Asset pair.
 */
@ApiModel("A symbol price index.")
public record PriceIndex(@ApiModelProperty("Last price calculation timestamp in ms.") long calcTime, @ApiModelProperty("Price.") String price,
		@ApiModelProperty("Asset pair.") String symbol) {
}
