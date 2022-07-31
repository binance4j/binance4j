package com.binance4j.wallet.dto;

/**
 * The snapshot assets balances.
 * 
 * @param asset         The asset abbreviation.
 * @param marginBalance The margin balance.
 * @param walletBalance The wallet balance.
 */
public record FuturesSnapshotDataAssets(String asset, String marginBalance, String walletBalance) {
}