package com.binance4j.wallet.dust;

import com.binance4j.core.param.IntervalParams;

/**
 * The parameters to get dust operations (assets to BNB) logs
 */
public class DustLogParams extends IntervalParams {
	/**
	 * Default constructor
	 */
	public DustLogParams() {
		super(1);
	}
}
