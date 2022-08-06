package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The allowed maximum position an account can have on the base asset of a symbol.
 *
 * @param maxNumIcebergOrders Max iceberg orders.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The allowed maximum position an account can have on the base asset of a symbol.")
public record MaxNumIcebergOrdersFilter(@ApiModelProperty("Max iceberg orders.") int maxNumIcebergOrders) {
}