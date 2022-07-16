package com.binance4j.margin.param;

import com.binance4j.core.param.FramedParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAccount} params. */
public class GetAccountParams extends FramedParams {
	/** Default constructor */
	public GetAccountParams() {
		super(10);
	}
}
