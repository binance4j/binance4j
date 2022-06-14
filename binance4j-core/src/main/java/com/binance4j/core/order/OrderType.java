package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type of order to submit to the system.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType {
  /** The order is a limit order */
  LIMIT,
  /** The order is a market order */
  MARKET,
  /** The order is a stop loss order */
  STOP_LOSS,
  /** The order is a stop loss limit order */
  STOP_LOSS_LIMIT,
  /** The order is a take profit order */
  TAKE_PROFIT,
  /** The order is a take profit limit order */
  TAKE_PROFIT_LIMIT,
  /** The order is a limit maker order */
  LIMIT_MAKER
}
