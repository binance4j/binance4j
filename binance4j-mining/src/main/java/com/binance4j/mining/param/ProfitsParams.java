package com.binance4j.mining.param;

import com.binance4j.core.param.Params;

public class ProfitsParams extends Params {
	/** Transfer algorithm. */
	String algo;
	/** Mining account test. */
	String userName;
	/** Coin name. */
	String coin;
	/** Search date, millisecond timestamp, while empty query all. */
	Long startDate;
	/** Search date, millisecond timestamp, while empty query all. */
	Long endDate;
	/** Page number, empty default first page, starting from 1. */
	Integer pageIndex;
	/** Number of pages, minimum 10, maximum 200. */
	Integer pageSize;

	/** Constructor. */
	public ProfitsParams() {
		super(5);
	}

}
