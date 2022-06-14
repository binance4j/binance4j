package com.binance4j.strategy.bar;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.ta4j.core.Bar;
import org.ta4j.core.BaseBar;

/**
 * A Bar with the name of its symbol
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SymbolBar extends BaseBar {

	/**
	 * The name of the symbol of the bar
	 */
	private String symbol;

	/**
	 * @param bar    The input bar
	 * @param symbol The bar symbol name
	 */
	public SymbolBar(Bar bar, String symbol) {
		super(bar.getTimePeriod(),
				bar.getEndTime(),
				bar.getOpenPrice().longValue(),
				bar.getHighPrice().longValue(),
				bar.getLowPrice().longValue(),
				bar.getClosePrice().longValue(),
				bar.getVolume().longValue());
		this.symbol = symbol;
	}
}
