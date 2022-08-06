package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/**
 * {@link SavingsClient#getLeftDailyRedemptionQuota} params.
 * 
 * @param productId Product id.
 * @param type      Product type.
 */
@Param
public record RedemptionQuotaParams(String productId, ProductType type) implements Params {
}