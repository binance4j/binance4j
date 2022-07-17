package com.binance4j.market.param;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.param.Params;

/** The parameters to get the latest price for a symbol or symbols. */
public class PriceTickersParams extends Params {
	/** Ticker symbol. */
	private String symbols;

	/**
	 * .
	 *
	 * @param symbols The trading pairs we want the ticker
	 */
	public PriceTickersParams(Collection<String> symbols) {
		super(2);
		List<String> list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList());
		this.symbols = "[" + String.join(",", list) + "]";
	}

	/**
	 * .
	 *
	 * @param symbols The trading pairs we want the ticker
	 */
	public PriceTickersParams(String symbols) {
		this(Arrays.asList(symbols.split(",")));
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