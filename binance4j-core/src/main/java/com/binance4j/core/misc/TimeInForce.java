package com.binance4j.core.misc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Time in force to indicate how long an order will remain active before it is
 * executed or expires.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TimeInForce {
  /**
   * GTC (Good-Til-Canceled) orders are effective until they are executed or
   * canceled.
   */
  GTC,
  /**
   * IOC (Immediate or Cancel) orders fills all or part of an order immediately
   * and cancels the remaining part of the order.
   */
  IOC,
  /**
   * FOK (Fill or Kill) orders fills all in its entirety, otherwise, the entire
   * order will be cancelled.
   */
  FOK
}
