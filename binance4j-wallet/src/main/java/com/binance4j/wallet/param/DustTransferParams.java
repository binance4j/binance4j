package com.binance4j.wallet.param;

import java.util.List;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/** The parameters to convert small volumes (dust) into BNB */
@Param(weight = 10, type = RateLimitType.UID)
public class DustTransferParams implements Params {
	/** The list of assets to convert into BNB. */
	@Mandatory
	List<String> assets;

	/**
	 * @param assets The list of assets to convert into BNB.
	 */
	public DustTransferParams(List<String> assets) {
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
