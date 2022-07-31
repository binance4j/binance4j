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
public record RedemptionResponse(long id, String status, String tokenName, String redeemAmount, String amount, long timestamp) {
}