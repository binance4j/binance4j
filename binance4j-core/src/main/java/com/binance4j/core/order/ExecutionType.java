package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Order execution type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ExecutionType {
  /** Order is new */
  NEW,
  /** Order is canceled */
  CANCELED,
  /** Order is replaced */
  REPLACED,
  /** Order is rejected */
  REJECTED,
  /** Order is trade */
  TRADE,
  /** Order is expired */
  EXPIRED
}
