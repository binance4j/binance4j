package com.binance4j.blvt.dto;

/**
 * BVLT subscription response.
 * 
 * @param id        Subscription id.
 * @param status    Subscription status. S("success"), P("pending"), and F("failure").
 * @param tokenName Token name.
 * @param amount    Subscribed token amount.
 * @param timestamp Timestamp in ms.
 */
public record SubscriptionResponse(long id, String status, String tokenName, String amount, String cost, long timestamp) {
}