package com.binance4j.wallet.dto;

/** A daily MARGIN account snapshot */
public record MarginAccountSnapshot(String type, long updateTime, MarginAccountSnapshotData data) implements Snapshot {
}