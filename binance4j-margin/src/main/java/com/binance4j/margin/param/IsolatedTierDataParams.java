package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedMarginTierData} params. */
@Param
public class IsolatedTierDataParams implements Params {
	/** The symbol */
	@Mandatory
	String symbol;
	/** The tier */
	String tier;

	/** @param symbol The symbol */
	public IsolatedTierDataParams(String symbol) {
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
