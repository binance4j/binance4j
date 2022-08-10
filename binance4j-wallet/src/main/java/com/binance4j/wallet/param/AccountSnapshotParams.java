package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to get a list of SPOT, MARGIN or FUTURES daily account
 * snapshots
 */
@Param(weight = 2400)
public record AccountSnapshotParams() implements Params {
}