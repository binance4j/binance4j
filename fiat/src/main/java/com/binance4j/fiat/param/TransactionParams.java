package com.binance4j.fiat.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.TransactionType;

/**
 * {@link FiatClient#getTransactions} params.
 * 
 * @param transactionType Transaction type.
 */
@Param(weight = 90000, type = RateLimitType.UID)
public record TransactionParams(String transactionType) implements Params {
	/**
	 * @param transactionType Transaction type.
	 */
	public TransactionParams(TransactionType transactionType) {
		this(transactionType.toString());
	}
}