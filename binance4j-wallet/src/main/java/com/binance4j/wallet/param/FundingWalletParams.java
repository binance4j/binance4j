package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getFundingWallet} params.
 * 
 * @param asset            Asset we want the balance.
 * @param needBtcValuation Get the BTC value of the asset.
 */
@Param
public record FundingWalletParams(String asset, Boolean needBtcValuation) implements Params {

	/**
	 * Creates an instance of {@link FundingWalletParams}.
	 * 
	 * @param asset Asset we want the balance.
	 */
	public FundingWalletParams(String asset) {
		this(asset, null);
	}

	/**
	 * Creates an instance of {@link FundingWalletParams}.
	 * 
	 * @param needBtcValuation Get the BTC value of the asset.
	 */
	public FundingWalletParams(Boolean needBtcValuation) {
		this(null, needBtcValuation);
	}
}