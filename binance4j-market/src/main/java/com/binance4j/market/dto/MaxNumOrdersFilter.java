package com.binance4j.market.dto;

/**
 * Defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders and
 * normal orders are counted for this filter.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @param maxNumOrders The max number of orders allowed.
 */
public record MaxNumOrdersFilter(int maxNumOrders) {
}