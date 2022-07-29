package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient} params.
 * 
 * @param product   Product type.
 * @param productId Product id.
 */
public record LeftQuotaParams(@Mandatory ProductType product, @Mandatory String productId) implements Params {
}