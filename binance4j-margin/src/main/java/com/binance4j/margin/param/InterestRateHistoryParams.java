package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllOCO} params. */
public class InterestRateHistoryParams extends IntervalParams {
	/** The asset */
	private String asset;
	/** The VIP level */
	private Integer vipLevel;

	/**
	 * @param asset The asset
	 */
	public InterestRateHistoryParams(String asset) {
		super();
		this.asset = asset;
	}

	/**
	 * @return the asset
	 */
	public String getAsset() {
		return asset;
	}

	/**
	 * @param asset the asset to set
	 */
	public void setAsset(String asset) {
		this.asset = asset;
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