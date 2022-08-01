package com.binance4j.staking.param;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;

/**
 * {@link StakingClient#getHistory} params.
 * 
 * @param product         The product type.
 * @param transactionType The transaction type.
 * @param asset           The product name.
 */
public record HistoryParams(ProductType product, TransactionType txnType, String asset) implements Params {
	/**
	 * Creates an instance of {@link HistoryParams}.
	 * 
	 * @param product         The product type.
	 * @param transactionType The transaction type.
	 */
	public HistoryParams(ProductType product, TransactionType transactionType) {
		this(product, transactionType, null);
	}
}