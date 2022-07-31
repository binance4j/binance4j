package com.binance4j.pay.dto;

/**
 * Funds detail.
 * 
 * @param currency The asset.
 * @param amount   The amount.
 */
public record FundsDetail(String currency, String amount) {
}
