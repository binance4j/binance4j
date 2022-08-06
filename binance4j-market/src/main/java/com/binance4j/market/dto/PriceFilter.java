package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * * Defines the price rules for a symbol.
 * 
 * @param minPrice The minimum price/stopPrice allowed. Disabled on minPrice == 0.
 * @param maxPrice The maximum price/stopPrice allowed. Disabled on maxPrice == 0.
 * @param tickSize The intervals that a price/stopPrice can be increased/decreased by. Disabled on tickSize == 0.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("")
public record PriceFilter(@ApiModelProperty("") String minPrice, @ApiModelProperty("") String maxPrice, @ApiModelProperty("") String tickSize) {
}