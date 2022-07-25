package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllOCO} params. */
public class InterestRateHistoryParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The asset */
	private String asset;
	/** The VIP level */
	private Integer vipLevel;

	/** @param asset The asset */
	public InterestRateHistoryParams(String asset) {
		super();
		this.asset = asset;
	}

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the vipLevel */
	public Integer getVipLevel() {
		return vipLevel;
	}

	/** @param vipLevel the vipLevel to set */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}