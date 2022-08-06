package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#getRedemptions} params.
 * 
 * @param tokenName Token name.
 * @param id        Subscription id.
 */
@Param
public record TransactionRecordParams(String tokenName, Long id) implements Params {
	/**
	 * Creates instance of the class.
	 * 
	 * @param tokenName Token name.
	 * @param id        Subscription id.
	 */
	public TransactionRecordParams(String tokenName, Long id) {
		this.id = id;
		this.tokenName = tokenName;
	}

	/**
	 * Creates instance of the class.
	 * 
	 * @param tokenName Token name.
	 */
	public TransactionRecordParams(String tokenName) {
		this(tokenName, null);
	}

	/**
	 * Creates instance of the class.
	 * 
	 * @param id Subscription id.
	 */
	public TransactionRecordParams(Long id) {
		this(null, id);
	}
}