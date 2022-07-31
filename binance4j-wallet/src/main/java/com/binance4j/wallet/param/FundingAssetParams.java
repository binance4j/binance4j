package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getFundingAsset} params.
 * 
 * @param asset            The asset we want the balance.
 * @param needBtcValuation Get the BTC value of the asset.
 */
@Param
public record FundingAssetParams(String asset, Boolean needBtcValuation) implements Params {
	/**
	 * Creates an instance of {@link FundingAssetParams}.
	 */
	public FundingAssetParams() {
		this(null, null);
	}

	/**
	 * Creates an instance of {@link FundingAssetParams}.
	 * 
	 * @param asset The asset we want the balance.
	 */
	public FundingAssetParams(String asset) {
		this(asset, null);
	}

	/**
	 * Creates an instance of {@link FundingAssetParams}.
	 * 
	 * @param needBtcValuation Get the BTC value of the asset.
	 */
	public FundingAssetParams(Boolean needBtcValuation) {
		this(null, needBtcValuation);
	}
}