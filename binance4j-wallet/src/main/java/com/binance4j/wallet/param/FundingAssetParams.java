package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get the funding wallet */
public class FundingAssetParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The asset we want the balance. */
	private String asset;

	/** Get the BTC value of the asset. */
	private Boolean needBtcValuation;

	/**
	 
	 */
	public FundingAssetParams() {
		super(1);
	}

	/**
	 * @param asset The asset we want the balance.
	 */
	public FundingAssetParams(String asset) {
		this();
		this.asset = asset;
	}

	/**
	 * @param asset            The asset we want the balance.
	 * @param needBtcValuation Dlo we want the value of the balance in bitcoin?
	 */
	public FundingAssetParams(String asset, Boolean needBtcValuation) {
		this(asset);
		this.needBtcValuation = needBtcValuation;
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
	 * @return the needBtcValuation
	 */
	public Boolean getNeedBtcValuation() {
		return needBtcValuation;
	}

	/**
	 * @param needBtcValuation the needBtcValuation to set
	 */
	public void setNeedBtcValuation(Boolean needBtcValuation) {
		this.needBtcValuation = needBtcValuation;
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
