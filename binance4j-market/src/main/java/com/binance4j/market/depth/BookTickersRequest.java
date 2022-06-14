package com.binance4j.market.depth;

import com.binance4j.core.request.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A request to get the the best price/qty on the order book for the given
 * symbols.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BookTickersRequest extends Request {
	/**
	 * Ticker symbol.
	 */
	private String symbols;

	/**
	 * Constructor.
	 *
	 * @param symbols The trading pairs we want the ticker
	 */
	public BookTickersRequest(Collection<String> symbols) {
		super(2);
		List<String> list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s)).collect(Collectors.toList());
		this.symbols = "[" + String.join(",", list) + "]";
	}

	/**
	 * Constructor.
	 *
	 * @param symbols The trading pairs we want the ticker
	 */
	public BookTickersRequest(String symbols) {
		this(Arrays.asList(symbols.split(",")));
	}
}
