package com.binance4j.fiat.dto;

/**
 * A fiat payment.
 * 
 * @param orderNo        Order No.
 * @param sourceAmount   Fiat trade amount.
 * @param fiatCurrency   Fiat token.
 * @param obtainAmount   Crypto trade amount.
 * @param cryptoCurrency Crypto token.
 * @param totalFee       Trade fee.
 * @param price          Price.
 * @param status         Status: {@code Processing}, {@code Completed}, {@code Failed}, {@code Refunded}.
 * @param createTime     Create time in ms.
 * @param updateTime     Update time in ms.
 */
public record Payment(String orderNo, String sourceAmount, String fiatCurrency, String obtainAmount, String cryptoCurrency, String totalFee, String price,
		String status, long createTime, long updateTime) {
}
