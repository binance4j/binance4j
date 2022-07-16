package com.binance4j.wallet.param;

import com.binance4j.wallet.dto.AccountSnapshotResponse;

import lombok.ToString;

/** The response of a MARGIN account snapshot request */
@ToString(callSuper = true)
public class MarginAccountSnapshotResponse extends AccountSnapshotResponse<MarginAccountSnapshot> {
}