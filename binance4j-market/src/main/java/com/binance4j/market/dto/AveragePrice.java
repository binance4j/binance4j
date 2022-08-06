package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Current average price for a symbol.
 * 
 * @param mins  Mins.
 * @param price Average price of the asset.
 */
@ApiModel("Current average price for a symbol.")
public record AveragePrice(@ApiModelProperty("Mins.") int mins, @ApiModelProperty("Average price of the asset.") String price) {
}
