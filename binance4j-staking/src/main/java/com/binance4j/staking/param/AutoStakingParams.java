package com.binance4j.staking.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * {@link StakingClient#setAutoStaking} params.
 * 
 * @param product    The product type.
 * @param positionId The position id.
 * @param renewable  Renew purchase?
 */
@Param
public record AutoStakingParams(@Mandatory ProductType product, @Mandatory String positionId, @Mandatory Boolean renewable) implements Params {
}
