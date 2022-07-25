package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/** The parameters to get details about a supported asset */
public class AssetDetailParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The asset abbreviation. */
	private String asset;

	/** Default constructor. */
	public AssetDetailParams() {
		super(1);
	}

	/**
	 * @param asset the asset we want the details.
	 */
	public AssetDetailParams(String asset) {
		this();
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

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
