package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedMarginTierData} params. */
public class IsolatedTierDataParams extends Params {

	/** The symbol */
	private String symbol;
	/** The tier */
	private String tier;

	/** @param symbol The symbol */
	public IsolatedTierDataParams(String symbol) {
		super();
		this.symbol = symbol;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the tier */
	public String getTier() {
		return tier;
	}

	/** @param tier the tier to set */
	public void setTier(String tier) {
		this.tier = tier;
	}

}
