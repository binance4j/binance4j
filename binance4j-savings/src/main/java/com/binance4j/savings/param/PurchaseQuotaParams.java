package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#getLeftDailyFlexiblePurchaseQuota} params.
 * 
 * @param productId Product id.
 */
public record PurchaseQuotaParams(@Mandatory String productId) implements Params {
}