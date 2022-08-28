package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;
import com.binance4j.savings.dto.ProductType;

/**
 * [SavingsClient.redeemFlexible] params.
 * 
 * @param productId Product id.
 * @param amount    Amount.
 * @param type      Product type.
 */
@Param
data class RedemptionParams(String productId, String amount, ProductType type) : Params {
}