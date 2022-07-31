package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getDepositAddress} params.
 * 
 * @param coin    The coin abbreviation.
 * @param network The transfer network.
 */
@Param(weight = 10)
public record DepositAddressParams(@Mandatory String coin, String network) implements Params {
	/***
	 * Creates an instance of {@link DepositAddressParams}.
	 * 
	 * @param coin The coin abbreviation.
	 */
	public DepositAddressParams(String coin) {
		this(coin, null);
	}
}