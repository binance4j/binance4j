package com.binance4j.market.tickerstatistics;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The parameters to get the 24 hour rolling window price change statistics.
 * Careful when accessing this with no symbol.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TickerStatisticsParams extends Params {
	/** The trading pair we want the ticker stats */
	private String symbol;

	/** to get all ticker stats */
	public TickerStatisticsParams() {
		super(40);
	}

	/**
	 * to get the ticker stats of a symbol
	 *
	 * @param symbol The trading pair we want the ticker stats
	 */
	public TickerStatisticsParams(String symbol) {
		super(1);
		this.symbol = symbol;
	}
}
