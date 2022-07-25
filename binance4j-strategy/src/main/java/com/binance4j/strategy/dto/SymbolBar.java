package com.binance4j.strategy.dto;

import org.ta4j.core.Bar;
import org.ta4j.core.BaseBar;

/** A Bar with the name of its symbol */
public class SymbolBar extends BaseBar {
	/** The name of the symbol of the bar. */
	String symbol;
	/** is it the last bar of the interval? */
	boolean isBarFinal;

	/**
	 * @param bar        The input bar.
	 * @param isBarFinal Is the bar final?
	 * @param symbol     The bar symbol name.
	 */
	public SymbolBar(Bar bar, boolean isBarFinal, String symbol) {
		super(bar.getTimePeriod(), bar.getEndTime(), bar.getOpenPrice().doubleValue(), bar.getHighPrice().doubleValue(), bar.getLowPrice().doubleValue(),
				bar.getClosePrice().doubleValue(), bar.getVolume().doubleValue());
		this.symbol = symbol;
		this.isBarFinal = isBarFinal;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the isBarFinal
	 */
	public boolean isBarFinal() {
		return isBarFinal;
	}

	/**
	 * @param isBarFinal the isBarFinal to set
	 */
	public void isBarFinal(boolean isBarFinal) {
		this.isBarFinal = isBarFinal;
	}
}