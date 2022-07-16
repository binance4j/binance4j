package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * * Defines the maximum number of orders an account is allowed to have open on a symbol. Note that both "algo" orders
 * and normal orders are counted for this filter.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @param maxNumAlgoOrders The maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo"
 *                         orders are {@code STOP_LOSS} {@code STOP_LOSS_LIMIT} {@code TAKE_PROFIT} and
 *                         {@code TAKE_PROFIT_LIMIT} orders.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxNumAlgoOrdersFilter(
		/**
		 * The maximum number of "algo" orders an account is allowed to have open on a symbol. "Algo" orders are
		 * {@code STOP_LOSS} {@code STOP_LOSS_LIMIT} {@code TAKE_PROFIT} and {@code TAKE_PROFIT_LIMIT} orders.
		 */
		BigDecimal maxNumAlgoOrders) {
}