package com.binance4j.market.param;

import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getExchangeInfo} params.
 * 
 * @param symbols Symbols.
 */
@Param(weight = 10, recvWindow = false, timestamp = false)
public record ExchangeInfoParams(String symbols) implements Params {
	/** Creates an instance of {@link ExchangeInfoParams}. */
	public ExchangeInfoParams() {
		this((String) null);
	}

	/**
	 * @param symbols Trading pair list.
	 */
	public ExchangeInfoParams(String symbols) {
		this.symbols = "[" + List.of(symbols.split(",")).stream().map(s -> String.format("\"%s\"", s.trim())).collect(Collectors.joining(",")) + "]";
	}

	/**
	 * @param symbols Trading pair list.
	 */
	public ExchangeInfoParams(List<String> symbols) {
		this(symbols.stream().collect(Collectors.joining(",")));
	}
}