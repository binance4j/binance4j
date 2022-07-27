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
public record Payment(
		/** Order No. */
		String orderNo,
		/** Fiat trade amount. */
		String sourceAmount,
		/** Fiat token. */
		String fiatCurrency,
		/** Crypto trade amount. */
		String obtainAmount,
		/** Crypto token. */
		String cryptoCurrency,
		/** Trade fee. */
		String totalFee,
		/** Price. */
		String price,
		/** Status: {@code Processing}, {@code Completed}, {@code Failed}, {@code Refunded}. */
		String status,
		/** Create time in ms. */
		long createTime,
		/** Update time in ms. */
		long updateTime) {

}
