package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get a list of asset dividends */
public class AssetDividendRecordParams extends Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;

	/** The asset abbreviation. */
	String asset;
	/** The result limit. Default 20, max 500 */
	Integer limit = 20;

	/** Default constructor. */
	public AssetDividendRecordParams() {
		super(10);
	}

	/**
	 * with asset
	 *
	 * @param asset The asset we want the records.
	 */
	public AssetDividendRecordParams(String asset) {
		this();
		this.asset = asset;
	}

	/**
	 * with asset and limit
	 *
	 * @param asset The asset we want the records.
	 * @param limit The result limit.
	 */
	public AssetDividendRecordParams(String asset, Integer limit) {
		this(asset);
		this.limit = limit;
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
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
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
