package com.binance4j.market.param;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.annotation.Mandatory;

/**
 * The parameters to get the 24 hour rolling window price change statistics of specific symbols.
 */
public class TickersStatisticsParams extends MarketParams {
	/** The trading pair we want the ticker stats. */
	@Mandatory
	String symbols;

	/**
	 * to get the ticker stats of multiple symbol
	 *
	 * @param symbols The trading pairs we want the ticker stats.
	 */
	public TickersStatisticsParams(Collection<String> symbols) {
		super(0);

		List<String> list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList());

		if (list.size() <= 21) {
			weight = 1;
		} else if (list.size() <= 101) {
			weight = 20;
		} else {
			weight = 40;
		}

		this.symbols = "[" + String.join(",", list) + "]";
	}

	/**
	 * to get the ticker stats of multiple symbol
	 *
	 * @param symbols The trading pairs we want the ticker stats.
	 */
	public TickersStatisticsParams(String symbols) {
		this(Arrays.asList(symbols.split(",")));
	}

	/**
	 * @return the symbols.
	 */
	public String getSymbols() {
		return symbols;
	}

	/**
	 * @param symbols the symbols to set.
	 */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}
}