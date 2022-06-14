package com.binance4j.core.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Status of a submitted order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderStatus {
  /** The order is a new order */
  NEW,
  /** The order is partially filled. Some quantity is not sold/bought yet */
  PARTIALLY_FILLED,
  /** The order is totally filled */
  FILLED,
  /** The order is canceled */
  CANCELED,
  /** The order is waiting for cancelation */
  PENDING_CANCEL,
  /** The order has been rejected */
  REJECTED,
  /** The order has expired */
  EXPIRED
}
