package com.binance4j.wallet.dto;

import java.util.List;

/** The response of a FUTURES account snapshot request */
public record FuturesAccountSnapshotResponse(int code, String msg, List<FuturesAccountSnapshot> snapshotVos)
		implements AccountSnapshotResponse<FuturesAccountSnapshot> {
}