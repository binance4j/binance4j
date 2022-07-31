package com.binance4j.blvt.dto;

/**
 * A BLVT redemption.
 * 
 * @param id          Id.
 * @param tokenName   Token name.
 * @param amount      Amount.
 * @param nav         Nav.
 * @param fee         Fee.
 * @param totalCharge Total charge.
 * @param timestamp   Timestamp in ms.
 */
public record Redemption(long id, String tokenName, String amount, String nav, String fee, String totalCharge, long timestamp) {
}