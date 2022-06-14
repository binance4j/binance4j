package com.binance4j.wallet.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Status of a submitted order.
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransferType {
  SPOT_TO_MARGIN("1"),
  MARGIN_TO_SPOT("2");

  @Getter
  private String value;
}
