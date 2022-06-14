package com.binance4j.wallet.snapshot.spot;

import com.binance4j.wallet.snapshot.AccountSnapshotResponse;
import lombok.ToString;

/**
 * The response of a SPOT account snapshot request
 */
@ToString(callSuper = true)
public class SpotAccountSnapshotResponse extends AccountSnapshotResponse<SpotAccountSnapshot> {
}