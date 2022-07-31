package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get details about a supported asset.
 * 
 * @param asset The asset abbreviation.
 */
public record AssetDetailParams(String asset) implements Params {
	/**
	 * Creates an instance of {@link AssetDetailParams}.
	 */
	public AssetDetailParams() {
		this(null);
	}
}