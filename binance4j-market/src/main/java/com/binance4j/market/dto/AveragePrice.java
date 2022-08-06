package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Current average price for a symbol.
 * 
 * @param mins  Mins.
 * @param price The average price of the asset.
 */
@ApiModel("")
public record AveragePrice(@ApiModelProperty("") int mins, @ApiModelProperty("") String price) {
}
