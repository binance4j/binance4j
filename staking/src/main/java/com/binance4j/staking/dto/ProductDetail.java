package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking product detail.
 * 
 * @property asset            Asset.
 * @property rewardAsset      Reward Asset.
 * @property duration         Duration in ms.
 * @property renewable        Renewable.
 * @property apy              Apy.
 * @property extraRewardAsset Extra reward asset.
 * @property extraRewardsAPY  Extra reward APY.
 * @property project          project.
 */
@ApiModel("Staking product detail.")
data class ProductDetail(
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Reward Asset.")
var rewardAsset:String?=null,
@ApiModelProperty("Duration in ms.")
var duration:int?=null,
@ApiModelProperty("Renewable.")
var renewable:Boolean?=null,
@ApiModelProperty("Apy.")
var apy:String?=null,
@ApiModelProperty("Extra reward asset.")
var extraRewardAsset:String?=null,
@ApiModelProperty("Extra reward APY.")
var extraRewardsAPY:String?=null,
@ApiModelProperty("project.")
var project:String?=null)
{
}
