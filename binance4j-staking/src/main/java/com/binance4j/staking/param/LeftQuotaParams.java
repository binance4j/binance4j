package com.binance4j.staking.param;

import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#getLeftQuota} params.
 * 
 * @param product   Product type.
 * @param productId Product id.
 */
public record LeftQuotaParams(ProductType product, String productId) implements Params {
}