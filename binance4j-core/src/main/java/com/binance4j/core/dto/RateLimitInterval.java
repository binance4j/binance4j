package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The parameters rate limit interval. */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RateLimitInterval {
  /** Interval will be in seconds. */
  SECOND,
  /** Interval will be in minutes. */
  MINUTE,
  /** Interval will be in days. */
  DAY
}
