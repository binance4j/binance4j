package com.binance4j.wallet.param;

import com.binance4j.core.param.Params;

/**
 * The parameters to get information of coins (available for deposit and withdraw) for user.
 */
public class CoinInformationParams extends Params {
	/**
	 * Constructor
	 */
	public CoinInformationParams() {
		super(10);
	}
}