package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Buy/Sell order side.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderSide {
  /** You want to buy */
  BUY,
  /** You want to sell */
  SELL
}
