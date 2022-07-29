package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#purchaseFixed} params.
 * 
 * @param productId The product id.
 * @param lot       The amount.
 */
public record FixedPurchaseParams(@Mandatory String productId, @Mandatory Long lot) implements Params {
}