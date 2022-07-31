package com.binance4j.wallet.dto;

import java.util.List;

/** The response of a SPOT account snapshot request */
public record SpotAccountSnapshotResponse(int code, String msg, List<SpotAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<SpotAccountSnapshot> {
}