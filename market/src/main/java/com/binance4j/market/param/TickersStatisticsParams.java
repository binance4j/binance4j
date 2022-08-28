package com.binance4j.market.param;

import java.util.List;
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
	 * @param symbols Trading pair list.
	 */
	public TickersStatisticsParams(String symbols) {
		this.symbols = "[" + List.of(symbols.split(",")).stream().map(s -> String.format("\"%s\"", s.trim()))
				.collect(Collectors.joining(",")) + "]";
	}

	/**
	 * @param symbols Trading pair list.
	 */
	public TickersStatisticsParams(List<String> symbols) {
		this(symbols.stream().collect(Collectors.joining(",")));
	}
}