package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getMarginFeeData} params. */
public class CrossFeeParams extends FramedParams {
	/** The related coin */
	private final String coin;
	/** The related VIP level */
	private Integer vipLevel;

	/** Default constructor */
	public CrossFeeParams() {
		super(5);
		coin = null;
	}

	/**
	 * @param coin The related coin
	 */
	public CrossFeeParams(String coin) {
		super();
		this.coin = coin;
	}

	/**
	 * @return the coin
	 */
	public String getCoin() {
		return coin;
	}

	/**
	 * @return the vipLevel
	 */
	public Integer getVipLevel() {
		return vipLevel;
	}

	/**
	 * @param vipLevel the vipLevel to set
	 */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}
}