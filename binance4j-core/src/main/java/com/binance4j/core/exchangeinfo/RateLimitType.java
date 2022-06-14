package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A request rate limit type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitType {
  /** The request weight (!= count) */
  REQUEST_WEIGHT,
  /** The orders count */
  ORDERS,
  /** The requests that are not orders count */
  RAW_REQUESTS
}
