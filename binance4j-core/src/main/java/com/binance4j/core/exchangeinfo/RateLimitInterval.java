package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A request rate limit interval.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitInterval {
  /** Interval will be in seconds */
  SECOND,
  /** Interval will be in minutes */
  MINUTE,
  /** Interval will be in days */
  DAY
}
