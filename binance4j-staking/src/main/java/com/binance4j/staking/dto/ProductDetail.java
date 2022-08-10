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
@ApiModel("Staking product detail.")
public record ProductDetail(@ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Reward Asset.") String rewardAsset,
		@ApiModelProperty("Duration in ms.") int duration, @ApiModelProperty("Renewable.") boolean renewable,
		@ApiModelProperty("Apy.") String apy,
		@ApiModelProperty("Extra reward asset.") String extraRewardAsset,
		@ApiModelProperty("Extra reward APY.") String extraRewardsAPY,
		@ApiModelProperty("project.") String project) {
}
