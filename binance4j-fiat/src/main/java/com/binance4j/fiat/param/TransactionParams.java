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
 * @param beginTime       Begin time in ms.
 * @param endTime         End time in ms.
 */
@Param(weight = 90000, type = RateLimitType.UID)
public record TransactionParams(TransactionType transactionType, Long beginTime, Long endTime) implements Params {
	/**
	 * Creates an instance of {@link TransactionParams}.
	 * 
	 * @param transactionType Transaction type.
	 */
	public TransactionParams(TransactionType transactionType) {
		this(transactionType, null, null);
	}
}