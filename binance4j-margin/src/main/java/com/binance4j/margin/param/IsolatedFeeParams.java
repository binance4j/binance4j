package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedFeeData} params. */
@Param(weight = 10)
public class IsolatedFeeParams implements Params {
	/** The symbol */
	String symbol;
	/** The VIP level */
	Integer vipLevel;

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