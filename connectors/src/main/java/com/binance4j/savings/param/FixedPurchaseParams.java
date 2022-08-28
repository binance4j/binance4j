package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/**
 * [SavingsClient.purchaseFixed] params.
 * 
 * @param productId Product id.
 * @param lot       Amount.
 */
@Param
data class FixedPurchaseParams(String productId, Long lot) : Params {
}