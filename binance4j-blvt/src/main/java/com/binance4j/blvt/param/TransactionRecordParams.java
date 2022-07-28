package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#getRedemptions} params.
 * 
 * @param tokenName The token name.
 * @param id        The subscription id.
 */
@Param
public record TransactionRecordParams(String tokenName, Long id) implements Params {
	/** Creates instance of {@link TransactionRecordParams}. */
	public TransactionRecordParams() {
		this(null, null);
	}

	/**
	 * Creates instance of {@link TransactionRecordParams}.
	 * 
	 * @param tokenName The token name.
	 */
	public TransactionRecordParams(String tokenName) {
		this(tokenName, null);
	}

	/**
	 * Creates instance of {@link TransactionRecordParams}.
	 * 
	 * @param id The subscription id.
	 */
	public TransactionRecordParams(Long id) {
		this(null, id);
	}
}