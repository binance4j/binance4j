package com.binance4j.wallet.param;

import java.util.List;

import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/** The parameters to convert small volumes (dust) into BNB */
public class DustTransferParams extends Params {

	/** The list of assets to convert into BNB. */
	List<String> assets;

	/**
	 * @param assets The list of assets to convert into BNB.
	 */
	public DustTransferParams(List<String> assets) {
		super(10);
		rateLimitType = RateLimitType.UID;
		this.assets = assets;
	}

	/**
	 * @return the assets
	 */
	public List<String> getAssets() {
		return assets;
	}

	/**
	 * @param assets the assets to set
	 */
	public void setAssets(List<String> assets) {
		this.assets = assets;
	}

}
