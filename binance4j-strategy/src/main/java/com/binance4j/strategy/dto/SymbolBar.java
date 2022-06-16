package com.binance4j.strategy.dto;

import lombok.*;
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
	 * is it the last bar of the interval?
	 */
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private Boolean isBarFinal;

	/**
	 * @param bar    The input bar
	 * @param symbol The bar symbol name
	 */
	public SymbolBar(Bar bar, boolean isBarFinal, String symbol) {
		super(bar.getTimePeriod(),
				bar.getEndTime(),
				bar.getOpenPrice().doubleValue(),
				bar.getHighPrice().doubleValue(),
				bar.getLowPrice().doubleValue(),
				bar.getClosePrice().doubleValue(),
				bar.getVolume().doubleValue());
		this.symbol = symbol;
		this.isBarFinal = isBarFinal;
	}

	public Boolean isBarFinal() { return isBarFinal; }

	public void isBarFinal(boolean isBarFinal) {
		this.isBarFinal = isBarFinal;
	}
}
