package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The quantity (aka "lots" in auction terms) rules for MARKET orders on a
 * symbol.
 * 
 * @param minQty   Minimum quantity/iceberg quantity allowed.
 * @param maxQty   Maximum quantity/iceberg quantity allowed.
 * @param stepSize Intervals that a quantity/iceberg quantity can be
 *                 increased/decreased by.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The quantity (aka \"lots\" in auction terms) rules for MARKET orders on a symbol.")
public record MarketLotSizeFilter(@ApiModelProperty("Minimum quantity/iceberg quantity allowed.") String minQty,
		@ApiModelProperty("Maximum quantity/iceberg quantity allowed.") String maxQty,
		@ApiModelProperty("Intervals that a quantity/iceberg quantity can be increased/decreased by.") String stepSize) {
}