package com.binance4j.fiat.dto;

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
public record Transaction(String orderNo, String fiatCurrency, String indicatedAmount, String amount, String totalFee, String method, String status,
		long createTime, long updateTime) {
}
