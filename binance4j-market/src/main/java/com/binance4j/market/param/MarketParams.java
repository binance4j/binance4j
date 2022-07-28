package com.binance4j.market.param;

import com.binance4j.core.param.Params;

/** Base Params for market Params. */
public class MarketParams extends Params {
	/**
	 * @param weight The request weight
	 */
	public MarketParams(int weight) {
		super(weight);
		init();
	}

	/**
	 * Constructor.
	 */
	public MarketParams() {
		init();
	}

	private void init() {
		timestamp = null;
		recvWindow = null;
	}
}
