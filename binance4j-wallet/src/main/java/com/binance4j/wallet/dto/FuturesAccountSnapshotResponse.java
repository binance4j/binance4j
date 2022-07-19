package com.binance4j.wallet.dto;

import java.util.List;

import com.binance4j.wallet.param.FuturesAccountSnapshot;

/** The response of a FUTURES account snapshot request */
public record FuturesAccountSnapshotResponse(
		/** The response status code (200 for success; others are error codes) */
		int code,
		/** The potential response error message. */
		String msg,
		/** A list of account snapshots. */
		List<FuturesAccountSnapshot> snapshotVos) implements AccountSnapshotResponse<FuturesAccountSnapshot> {
}