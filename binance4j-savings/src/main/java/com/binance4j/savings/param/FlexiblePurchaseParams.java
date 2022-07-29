package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#purchaseFlexible} params.
 * 
 * @param productId Product id.
 * @param amount    Amount.
 */
public record FlexiblePurchaseParams(@Mandatory String productId, @Mandatory String amount) implements Params {
}