package com.binance4j.core.dto;

import java.util.List;

import com.binance4j.core.exception.ApiErrorCode;
import com.binance4j.core.exception.ApiException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The current exchange trading rules and symbol information.
 * 
 * @param timezone        The server timezone
 * @param serverTime      The server time
 * @param rateLimits      The request limits (weight, orders, raw...)
 * @param exchangeFilters The trading rules of the exchange
 * @param symbols         The available symbols on the exchange
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeInfo(
		/** The server timezone */
		String timezone,
		/** The server time */
		Long serverTime,
		/** The request limits (weight, orders, raw...) */
		List<RateLimit> rateLimits,
		/** The trading rules of the exchange */
		List<ExchangeFilter> exchangeFilters,
		/** The available symbols on the exchange */
		List<SymbolInfo> symbols) {

	/** The symbol exchange information */
	public SymbolInfo ymbolInfo(String symbol) throws ApiException {
		return symbols.stream().filter(symbolInfo -> symbolInfo.symbol().equals(symbol)).findFirst()
				.orElseThrow(() -> new ApiException(ApiErrorCode.UNKNOWN, String.format("Unable to obtain information for symbol %s", symbol)));
	}
}
