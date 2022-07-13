package com.binance4j.wallet.coinsinfo;

import com.binance4j.core.param.FramedParams;

/**
 * The parameters to get information of coins (available for deposit and
 * withdraw)
 * for user.
 */
public class CoinInformationParams extends FramedParams {
	/**
	 * Constructor
	 */
	public CoinInformationParams() {
		super(10);
	}
}