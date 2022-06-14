package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The status of a symbol on the exchange.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SymbolStatus {
  /**
   * <ul>
   * <li>Trading is enabled.</li>
   * <li>Orders can be canceled.</li>
   * <li>Market Data is generated</li>
   * </ul>
   */
  TRADING,
  /**
   * <ul>
   * <li>Trading is disabled.</li>
   * <li>Orders can be canceled.</li>
   * <li>Market Data is not generated</li>
   * </ul>
   */
  END_OF_DAY,
  /**
   * HALT is used during emergency situations. Market data is still being
   * generated during this time. To compare it with a traditional stock market,
   * HALT would be used if trading stopped due to the “market moved 7% too fast”
   * (similar to what the NYSE did recently).
   * <ul>
   * <li>Trading is disabled.</li>
   * <li>Orders can be canceled.</li>
   * <li>Market Data is generated</li>
   * </ul>
   */
  HALT,
  /**
   * BREAK is used during expected downtime. Market data is not being generated
   * for this symbol when the status is on BREAK. To compare it with a traditional
   * stock market, BREAK would be during a mid-day lunch break. BREAK is also set
   * for symbols where it has been delisted from the exchange.
   * <ul>
   * <li>Trading is disabled.</li>
   * <li>Orders can be canceled.</li>
   * <li>Market Data is not generated</li>
   * </ul>
   */
  BREAK,
  /** Binance devs reserved status */
  AUCTION_MATCH,
  /** Binance devs reserved status */
  PRE_TRADING,
  /** Binance devs reserved status */
  POST_TRADING;
}