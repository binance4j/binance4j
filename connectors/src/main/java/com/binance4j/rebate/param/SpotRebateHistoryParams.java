package com.binance4j.rebate.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.rebate.client.RebateClient;

/**
 * [RebateClient.getSpotRebateHistoryRecords] params.
 */
@Param(weight = 3000, type = RateLimitType.UID)
data class SpotRebateHistoryParams() : Params {
}
