package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The maximum number of orders an account is allowed to have open on a symbol.
 * Note that both "algo" orders and normal
 * orders are counted for this filter.
 * 
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @property maxNumOrders Max number of orders allowed.
 */
@ApiModel("The maximum number of orders an account is allowed to have open on a symbol.")
data class MaxNumOrdersFilter(@ApiModelProperty("Max number of orders allowed.") var maxNumOrders:int?=null)
{
}