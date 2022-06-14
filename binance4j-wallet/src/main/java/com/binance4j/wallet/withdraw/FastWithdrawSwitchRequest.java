package com.binance4j.wallet.withdraw;

import com.binance4j.core.request.FramedRequest;

/**
 * A request to toggle fast withdraw switch
 */
public class FastWithdrawSwitchRequest extends FramedRequest {
	public FastWithdrawSwitchRequest() {
		super(1);
	}
}
