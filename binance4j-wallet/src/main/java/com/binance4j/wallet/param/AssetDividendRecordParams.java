package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get a list of asset dividends.
 * 
 * @param asset Asset.
 */
@Param(weight = 10)
public record AssetDividendRecordParams(String asset) implements Params {

	/**
	 * Creates an instance of {@link AssetDividendRecordParams}.
	 */
	public AssetDividendRecordParams() {
		this(null);
	}

}