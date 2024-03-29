package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The maximum parts an iceberg order can have. The number of Iceberg parts is
 * defined as CEIL(qty/icebergQty).
 * 
 * @param limit Filter limit number.
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@ApiModel("The maximum parts an iceberg order can have.")
public record IcebergPartsFilter(@ApiModelProperty("The filter limit number.") int limit) {
}