package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A symbol price index.
 * 
 * @property calcTime Last price calculation timestamp in ms.
 * @property price    Price.
 * @property symbol   Asset pair.
 */
@ApiModel("A symbol price index.")
data class PriceIndex(
@ApiModelProperty("Last price calculation timestamp in ms.")
 val calcTime : Long,
@ApiModelProperty("Price.")
 val price : String,
@ApiModelProperty("Asset pair.")
 val symbol : String)
{
}
