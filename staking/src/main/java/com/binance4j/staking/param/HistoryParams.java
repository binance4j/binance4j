package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;

/**
 * {@link StakingClient#getHistory} params.
 * 
 * @param product Product type.
 * @param txnType Transaction type.
 * @param asset   Product name.
 */
@Param
public record HistoryParams(String product, String txnType, String asset) implements Params {
	/**
	 * Creates an instance of {@link HistoryParams}.
	 * 
	 * @param product Product type.
	 * @param txnType Transaction type.
	 * @param asset   Product name.
	 */
	public HistoryParams(ProductType product, TransactionType txnType, String asset) {
		this(product.toString(), txnType.toString(), null);
	}

	/**
	 * Creates an instance of {@link HistoryParams}.
	 * 
	 * @param product Product type.
	 * @param txnType Transaction type.
	 */
	public HistoryParams(ProductType product, TransactionType txnType) {
		this(product.toString(), txnType.toString(), null);
	}
}