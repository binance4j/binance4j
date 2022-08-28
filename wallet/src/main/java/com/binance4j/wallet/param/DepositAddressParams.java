package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getDepositAddress} params.
 * 
 * @param coin    Coin abbreviation.
 * @param network Transfer network.
 */
@Param(weight = 10)
public record DepositAddressParams(String coin, String network) implements Params {
	/***
	 * Creates an instance of {@link DepositAddressParams}.
	 * 
	 * @param coin Coin abbreviation.
	 */
	public DepositAddressParams(String coin) {
		this(coin, null);
	}
}