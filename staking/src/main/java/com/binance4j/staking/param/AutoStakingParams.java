package com.binance4j.staking.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.staking.client.StakingClient;
import com.binance4j.staking.dto.ProductType;

/**
 * [StakingClient.setAutoStaking] params.
 * 
 * @param product    Product type.
 * @param positionId Position id.
 * @param renewable  Renew purchase?
 */
@Param
data class AutoStakingParams(ProductType product, String positionId, Boolean renewable) : Params {
}
