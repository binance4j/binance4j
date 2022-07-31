package com.binance4j.wallet.dto;

/** A daily FUTURES account snapshot */
public record FuturesAccountSnapshot(String type, long updateTime, FuturesSnapshotData data) implements Snapshot {
}