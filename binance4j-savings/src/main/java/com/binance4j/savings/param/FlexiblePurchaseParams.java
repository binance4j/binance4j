package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * {@link SavingsClient#purchaseFlexible} params.
 * 
 * @param productId Product id.
 * @param amount    Amount.
 */
@Param
public record FlexiblePurchaseParams(String productId, String amount) implements Params {
}