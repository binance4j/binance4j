package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getAllCrossMarginPairs} params. */
public class AllMarginPairsParams extends Params {
	public AllMarginPairsParams() {
		super(10);
	}
}