package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking product detail.
 * 
 * @param asset            Asset.
 * @param rewardAsset      Reward Asset.
 * @param duration         Duration in ms.
 * @param renewable        Renewable.
 * @param apy              Apy.
 * @param extraRewardAsset Extra reward asset.
 * @param extraRewardsAPY  Extra reward APY.
 * @param project          project.
 */
@ApiModel("")
public record ProductDetail(@ApiModelProperty("") String asset, @ApiModelProperty("") String rewardAsset, @ApiModelProperty("") int duration,
		@ApiModelProperty("") boolean renewable, @ApiModelProperty("") String apy, @ApiModelProperty("") String extraRewardAsset,
		@ApiModelProperty("") String extraRewardsAPY, @ApiModelProperty("") String project) {
}
