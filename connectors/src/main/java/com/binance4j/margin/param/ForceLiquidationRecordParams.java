package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getForceLiquidationRecord] params.
 * 
 * @param isolatedSymbol Isolated symbol.
 */
data class ForceLiquidationRecordParams(String isolatedSymbol) : Params {
}
