package com.binance4j.savings.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/**
 * {@link SavingsClient#redeemFlexible} params.
 * 
 * @param productId Product id.
 * @param amount    Amount.
 * @param type      Product type.
 */
public record RedemptionParams(@Mandatory String productId, @Mandatory String amount, @Mandatory ProductType type) implements Params {
}