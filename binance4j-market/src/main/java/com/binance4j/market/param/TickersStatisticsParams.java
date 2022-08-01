package com.binance4j.market.param;

import java.util.Collection;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#get24hTickerStatistics} params.
 * 
 * @param symbols Symbols. Format: '["BTCBUSD","BNBBUSD"]'
 */
@Param(weight = 40, recvWindow = false, timestamp = false)
public record TickersStatisticsParams(String symbols) implements Params {
	/**
	 * Creates an instance of {@link TickersStatisticsParams}.
	 * 
	 * @param symbols Symbols.
	 */
	public TickersStatisticsParams(Collection<String> symbols) {
		this("[" + String.join(",", symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList())) + "]");
	}
}