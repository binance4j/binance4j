package com.binance4j.market.tickerstatistics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the 24 hour rolling window price change statistics of
 * specific symbols.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TickersStatisticsParams extends Params {
	/** The trading pair we want the ticker stats */
	private String symbols;

	/**
	 * to get the ticker stats of multiple symbol
	 *
	 * @param symbols The trading pairs we want the ticker stats
	 */
	public TickersStatisticsParams(Collection<String> symbols) {
		super(0);

		List<String> list = symbols.stream().map(String::trim).map(s -> String.format("\"%s\"", s))
				.collect(Collectors.toList());

		if (list.size() <= 21) {
			setWeight(1);
		} else if (list.size() <= 101) {
			setWeight(20);
		} else {
			setWeight(40);
		}

		this.symbols = "[" + String.join(",", list) + "]";
	}

	/**
	 * to get the ticker stats of multiple symbol
	 *
	 * @param symbols The trading pairs we want the ticker stats
	 */
	public TickersStatisticsParams(String symbols) {
		this(Arrays.asList(symbols.split(",")));
	}
}
