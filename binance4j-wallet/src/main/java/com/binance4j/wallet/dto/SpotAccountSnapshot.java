package com.binance4j.wallet.dto;

/** A daily SPOT account snapshot */
public record SpotAccountSnapshot(String type, long updateTime, SpotAccountSnapshotData data) implements Snapshot {
}