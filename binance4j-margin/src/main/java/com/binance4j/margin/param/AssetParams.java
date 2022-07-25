package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAsset} params. */
public class AssetParams extends Params {
	/** The asset we want infos about */
	String asset;

	/** @param asset The asset we want infos about */
	public AssetParams(String asset) {
		super(10);
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
}