package com.binance4j.market.param;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to retrieve the exchange trading rules and symbol information */
@Param(weight = 10, recvWindow = false, timestamp = false)
public class ExchangeInfoParams implements Params {
	/** The symbols we want info about */
	String symbols;

	/** Default Constructor. */
	public ExchangeInfoParams() {
	}

	/**
	 * @param symbols The trading pair list.
	 */
	public ExchangeInfoParams(List<String> symbols) {
		this();
		this.symbols = "[" + symbols.stream().map(s -> String.format("\"%s\"", s)).collect(Collectors.joining(",")) + "]";
	}

	/**
	 * @param symbol The trading pair.
	 */
	public ExchangeInfoParams(String symbol) {
		this(Collections.singletonList(symbol));
	}

	/**
	 * @return the symbols
	 */
	public String getSymbols() {
		return symbols;
	}

	/**
	 * @param symbols the symbols to set
	 */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
}