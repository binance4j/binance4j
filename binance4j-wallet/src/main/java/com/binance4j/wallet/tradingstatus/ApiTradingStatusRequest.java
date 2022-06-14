package com.binance4j.wallet.tradingstatus;

import com.binance4j.core.request.FramedRequest;

/**
 * A request to get the account api trading status detail.
 */
public class ApiTradingStatusRequest extends FramedRequest {
	/**
	 * Constructor
	 */
	public ApiTradingStatusRequest() {
		super(1);
	}
}
