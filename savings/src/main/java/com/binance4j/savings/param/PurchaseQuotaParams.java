package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * [SavingsClient.getLeftDailyFlexiblePurchaseQuota] params.
 * 
 * @param productId Product id.
 */
@Param
data class PurchaseQuotaParams(String productId) : Params {
}