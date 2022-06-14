package com.binance4j.wallet.snapshot.futures;

import com.binance4j.wallet.snapshot.AccountSnapshotResponse;
import lombok.ToString;

/**
 * The response of a FUTURES account snapshot request
 */
@ToString(callSuper = true)
public class FuturesAccountSnapshotResponse extends AccountSnapshotResponse<FuturesAccountSnapshot> {
}