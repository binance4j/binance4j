package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and
 * normal orders are counted for this filter.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @param maxNumOrders The max number of orders allowed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxNumOrdersFilter(
		/** The max number of orders allowed. */
		Integer maxNumOrders) {
}