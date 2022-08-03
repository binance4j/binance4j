package com.binance4j.staking.dto;

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
public record ProductDetail(String asset, String rewardAsset, int duration, boolean renewable, String apy, String extraRewardAsset, String extraRewardsAPY,
		String project) {
}
