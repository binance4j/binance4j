package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two forms: symbol filters and exchange
 * filters.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ExchangeFilterType {
  // Exchange
  /**
   * The {@code EXCHANGE_MAX_NUM_ORDERS} filter defines the maximum number of orders an account is allowed to have open on
   * the exchange. Note that both "algo" orders and normal orders are counted for this filter.
   */
  EXCHANGE_MAX_NUM_ORDERS,
  /**
   * The {@code EXCHANGE_MAX_NUM_ALGO_ORDERS} filter defines the maximum number of "algo" orders an account is allowed to
   * have open on the exchange. "Algo" orders are {@code STOP_LOSS}, {@code STOP_LOSS_LIMIT}, {@code TAKE_PROFIT}, and
   * {@code TAKE_PROFIT_LIMIT} orders.
   */
  EXCHANGE_MAX_NUM_ALGO_ORDERS,
}