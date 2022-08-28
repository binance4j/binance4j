package com.binance4j.fiat.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentType;

/**
 * {@link FiatClient#getPayments} params.
 * 
 * @param transactionType Payment type.
 */
@Param(weight = 90000, type = RateLimitType.UID)
public record PaymentParams(String transactionType) implements Params {
	/**
	 * @param transactionType Payment type.
	 */
	public PaymentParams(PaymentType transactionType) {
		this(transactionType.toString());
	}
}