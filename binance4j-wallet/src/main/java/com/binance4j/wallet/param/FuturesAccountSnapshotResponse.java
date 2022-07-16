package com.binance4j.wallet.param;

import com.binance4j.wallet.dto.AccountSnapshotResponse;

import lombok.ToString;

/** The response of a FUTURES account snapshot request */
@ToString(callSuper = true)
public class FuturesAccountSnapshotResponse extends AccountSnapshotResponse<FuturesAccountSnapshot> {
}