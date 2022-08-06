package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for a symbol.
 * 
 * @param minQty   The minimum quantity/iceberg Quantity allowed.
 * @param maxQty   The maximum quantity/iceberg Quantity allowed.
 * @param stepSize The intervals that a quantity/iceberg Quantity can be increased/decreased by.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("")
public record LotSizeFilter(@ApiModelProperty("") String minQty, @ApiModelProperty("") String maxQty, @ApiModelProperty("") String stepSize) {
}