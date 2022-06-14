package com.binance4j.core.exchangeinfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The current exchange trading rules and symbol information.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {
    /**
     * The server timezone
     */
  private String timezone;
    /**
     * The server time
     */
  private Long serverTime;
    /**
     * The request limits (weight, orders, raw...)
     */
  private List<RateLimit> rateLimits;
    /**
     * The trading rules of the exchange
     */
  private List<ExchangeFilter> exchangeFilters;
    /**
     * The available symbols on the exchange
     */
  private List<SymbolInfo> symbols;

    /**
     * The symbol exchange information
     */
  public SymbolInfo getSymbolInfo(String symbol) {
    return symbols.stream().filter(symbolInfo -> symbolInfo.getSymbol().equals(symbol))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Unable to obtain information for symbol " + symbol));
  }
}
