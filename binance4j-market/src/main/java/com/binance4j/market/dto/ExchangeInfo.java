package com.binance4j.market.dto;

import java.util.List;

import com.binance4j.core.dto.RateLimit;
import com.binance4j.core.exception.NotFoundException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The current exchange trading rules and symbol information.
 * 
 * @param timezone        The server timezone.
 * @param serverTime      The server time.
 * @param rateLimits      The request limits (weight,@ApiModelProperty("") orders,@ApiModelProperty("") raw...).
 * @param exchangeFilters The trading rules of the exchange.
 * @param symbols         The available symbols on the exchange.
 */
@ApiModel("")
public record ExchangeInfo(@ApiModelProperty("") String timezone, @ApiModelProperty("") long serverTime, @ApiModelProperty("") List<RateLimit> rateLimits,
		@ApiModelProperty("") List<ExchangeFilter> exchangeFilters, @ApiModelProperty("") List<SymbolInfo> symbols) {
	/**
	 * @param symbol The symbol we want the infos.
	 * @return The symbol exchange information.
	 * @throws NotFoundException Thrown if the symbol was not found
	 */
	public SymbolInfo getSymbolInfo(String symbol) throws NotFoundException {
		return symbols.stream().filter(symbolInfo -> symbolInfo.symbol().equals(symbol)).findFirst().orElseThrow(() -> new NotFoundException());
	}
}
