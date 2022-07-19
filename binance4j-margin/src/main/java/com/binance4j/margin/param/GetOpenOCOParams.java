package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getOpenOCO} params. */
public class GetOpenOCOParams extends FramedParams {
	/** Is the order isolated? */
	private Boolean isIsolated;
	/** mandatory for isolated margin, not supported for cross margin. */
	private String symbol;

	/** Default constructor */
	public GetOpenOCOParams() {
		super(10);
	}

	/** @return the isIsolated */.
	public Boolean getIsIsolated() {
		return isIsolated;
	}

	/** @param isIsolated the isIsolated to set */.
	public void setIsIsolated(Boolean isIsolated) {
		this.isIsolated = isIsolated;
	}

	/** @return the symbol */.
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */.
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
