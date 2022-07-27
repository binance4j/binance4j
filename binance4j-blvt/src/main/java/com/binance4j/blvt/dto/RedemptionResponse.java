package com.binance4j.blvt.dto;

/**
 * BLVT redemption response.
 * 
 * @param id           Subscription id.
 * @param status       Subscription status. S("success"), P("pending"), and F("failure").
 * @param tokenName    Token name.
 * @param amount       Redemption value in usdt.
 * @param redeemAmount Redemption token amount.
 * @param timestamp    Timestamp in ms.
 */
public record RedemptionResponse(
		/** Subscription id. */
		long id,
		/** Subscription status. S("success"), P("pending"), and F("failure"). */
		String status,
		/** Token name. */
		String tokenName,
		/** Redemption token amount. */
		String redeemAmount,
		/** Redemption value in usdt. */
		String amount,
		/** Timestamp in ms. */
		long timestamp) {
}