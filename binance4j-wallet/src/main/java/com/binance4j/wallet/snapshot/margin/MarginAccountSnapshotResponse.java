package com.binance4j.wallet.snapshot.margin;

import com.binance4j.wallet.snapshot.AccountSnapshotResponse;
import lombok.ToString;

/**
 * The response of a MARGIN account snapshot request
 */
@ToString(callSuper = true)
public class MarginAccountSnapshotResponse extends AccountSnapshotResponse<MarginAccountSnapshot> {
}