package com.binance4j.wallet.dto;

import java.util.List;

/** The response of a MARGIN account snapshot request */
public record MarginAccountSnapshotResponse(int code, String msg, List<MarginAccountSnapshot> snapshotVos)
		implements AccountSnapshotResponse<MarginAccountSnapshot> {
}