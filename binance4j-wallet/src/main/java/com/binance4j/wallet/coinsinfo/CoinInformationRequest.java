package com.binance4j.wallet.coinsinfo;

import com.binance4j.core.request.FramedRequest;

/**
 * A request to get information of coins (available for deposit and withdraw)
 * for user.
 */
public class CoinInformationRequest extends FramedRequest {
	/**
	 * Constructor
	 */
	public CoinInformationRequest() {
		super(10);
	}
}