package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.RateLimit;
import com.binance4j.core.exception.NotFoundException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The current exchange trading rules and symbol information.
 * 
 * @param timezone        Server timezone.
 * @param serverTime      Server time.
 * @param rateLimits      Request limits (weight, orders, raw...).
 * @param exchangeFilters Trading rules of the exchange.
 * @param symbols         Available symbols on the exchange.
 */
@ApiModel("The current exchange trading rules and symbol information.")
public record ExchangeInfo(@ApiModelProperty("Server timezone.") String timezone,
		@ApiModelProperty("Server time.") long serverTime,
		@ApiModelProperty("Request limits (weight, orders, raw...).") List<RateLimit> rateLimits,
		@ApiModelProperty("Trading rules of the exchange.") List<ExchangeFilter> exchangeFilters,
		@ApiModelProperty("Available symbols on the exchange.") List<SymbolInfo> symbols) {
	/**
	 * @param symbol Symbol we want the infos.
	 * @return The symbol exchange information.
	 * @throws NotFoundException Thrown if the symbol was not found
	 */
	public SymbolInfo getSymbolInfo(String symbol) throws NotFoundException {
		return symbols.stream().filter(symbolInfo -> symbolInfo.symbol().equals(symbol)).findFirst()
				.orElseThrow(() -> new NotFoundException());
	}
}
