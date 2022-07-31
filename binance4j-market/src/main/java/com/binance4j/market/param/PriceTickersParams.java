package com.binance4j.market.param;

import java.util.Collection;
import java.util.stream.Collectors;
import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getTicker} params.
 * 
 * @param symbols Symbols. Format: '["BTCBUSD","BNBBUSD"]'
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
public record PriceTickersParams(@Mandatory String symbols) implements Params {
	/**
	 * Creates an instance of {@link PriceTickersParams}.
	 * 
	 * @param symbols Symbols.
	 */
	public PriceTickersParams(Collection<String> symbols) {
		this("[" + String.join(",", symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList())) + "]");
	}
}