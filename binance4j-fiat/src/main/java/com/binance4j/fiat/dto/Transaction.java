package com.binance4j.fiat.dto;

import java.math.BigDecimal;

/**
 * A fiat transaction.
 * 
 * @param orderNo         Order No.
 * @param fiatCurrency    Fiat currency.
 * @param indicatedAmount Indicated amount.
 * @param amount          Amount.
 * @param totalFee        Total fee.
 * @param method          Method.
 * @param status          Status.
 * @param createTime      Create time in ms.
 * @param updateTime      Update time in ms.
 */
public record Transaction(
		/** Order No. */
		String orderNo,
		/** Fiat currency. */
		String fiatCurrency,
		/** Indicated amount. */
		BigDecimal indicatedAmount,
		/** Amount. */
		BigDecimal amount,
		/** Total fee. */
		BigDecimal totalFee,
		/** Method. */
		String method,
		/** Status. */
		String status,
		/** Create time in ms. */
		long createTime,
		/** Update time in ms. */
		long updateTime) {

}
