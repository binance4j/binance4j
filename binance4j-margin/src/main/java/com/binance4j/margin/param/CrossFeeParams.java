package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getMarginFeeData} params. */
@Param(weight = 5)
public class CrossFeeParams implements Params {
	/** The related coin */
	String coin;
	/** The related VIP level */
	Integer vipLevel;

	/** Constructor. */
	public CrossFeeParams() {
	}

	/** @param coin The related coin */
	public CrossFeeParams(String coin) {
		this.coin = coin;
	}

	/** @return the coin */
	public String getCoin() {
		return coin;
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