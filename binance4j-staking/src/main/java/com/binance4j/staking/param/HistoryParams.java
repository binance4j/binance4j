package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;
import com.binance4j.staking.dto.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link StakingClient#getHistory} params.
 * 
 * @param product         The product type.
 * @param transactionType The transaction type.
 * @param asset           The product name.
 */
public record HistoryParams(@Mandatory ProductType product, @Mandatory @JsonProperty("txnType") TransactionType transactionType, String asset)
		implements Params {
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