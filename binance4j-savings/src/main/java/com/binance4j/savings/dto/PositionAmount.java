package com.binance4j.savings.dto;

/**
 * Position Amount.
 * 
 * @param amount       Amount.
 * @param amountInBTC  Amount in BTC.
 * @param amountInUSDT Amount in USDT.
 * @param asset        Asset.
 */
public record PositionAmount(String amount, String amountInBTC, String amountInUSDT, String asset) {
}
