package com.binance4j.wallet.param;

import com.binance4j.wallet.dto.AccountSnapshotResponse;

import lombok.ToString;

/** The response of a SPOT account snapshot request */
@ToString(callSuper = true)
public class SpotAccountSnapshotResponse extends AccountSnapshotResponse<SpotAccountSnapshot> {
}