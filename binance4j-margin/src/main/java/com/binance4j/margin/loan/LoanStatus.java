package com.binance4j.margin.loan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Status of a submitted order.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LoanStatus {
  PENDING, CONFIRMED, FAILED
}
