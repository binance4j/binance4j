package com.binance4j.fiat.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.fiat.client.FiatClient;
import com.binance4j.fiat.dto.PaymentType;

/**
 * {@link FiatClient#getPayments} params.
 * 
 * @param paymentType Payment type.
 * @param beginTime   Begin time in ms.
 * @param endTime     End time in ms.
 */
@Param(weight = 90000, type = RateLimitType.UID)
public record PaymentParams(PaymentType paymentType, Long beginTime, Long endTime) implements Params {
	/**
	 * Creates an instance of {@link PaymentParams}.
	 * 
	 * @param paymentType Payment type.
	 */
	public PaymentParams(PaymentType paymentType) {
		this(paymentType, null, null);
	}
}