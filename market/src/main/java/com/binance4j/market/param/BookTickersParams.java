package com.binance4j.market.param;

import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * [MarketClient.getBookTicker] params.
 * 
 * @param symbols Symbols. Format: '["BTCBUSD","BNBBUSD"]'.
 */
@Param(weight = 2, recvWindow = false, timestamp = false)
data class BookTickersParams(
String symbols):Params
{

	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbols Trading pair list.
	 */
	public BookTickersParams(String symbols) {
		this.symbols = "[" + List.of(symbols.split(",")).stream().map(s -> String.format("\"%s\"", s.trim()))
				.collect(Collectors.joining(",")) + "]";
	}

	/**
	 * Creates an instance of the class.
	 * 
	 * @param symbols Trading pair list.
	 */
	public BookTickersParams(List<String> symbols) {
		this(symbols.stream().collect(Collectors.joining(",")));
	}
}