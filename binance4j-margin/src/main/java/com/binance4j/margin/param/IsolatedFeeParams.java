package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedFeeData} params. */
public class IsolatedFeeParams extends Params {

	/** The symbol */
	String symbol;
	/** The VIP level */
	Integer vipLevel;

	/** Default constructor */
	public IsolatedFeeParams() {
		super(10);
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @return the vipLevel */
	public Integer getVipLevel() {
		return vipLevel;
	}

	/** @param vipLevel the vipLevel to set */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

}