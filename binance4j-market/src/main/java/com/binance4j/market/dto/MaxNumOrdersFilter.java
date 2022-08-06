package com.binance4j.market.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and
 * normal orders are counted for this filter.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @param maxNumOrders The max number of orders allowed.
 */
@ApiModel("")
public record MaxNumOrdersFilter(@ApiModelProperty("") int maxNumOrders) {
}