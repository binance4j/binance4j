package com.binance4j.wallet.dto;

/** Futures account snapshot position. */
public record FuturesAccountSnapshotPosition(String symbol, String entryPrice, String markPrice, String positionAmt, String unRealizedProfit) {
}