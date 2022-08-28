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
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Reward Asset.")
@JsonProperty("rewardAsset") var rewardAsset:String?=null,
@ApiModelProperty("Duration in ms.")
@JsonProperty("duration") var duration:int?=null,
@ApiModelProperty("Renewable.")
@JsonProperty("renewable") var renewable:Boolean?=null,
@ApiModelProperty("Apy.")
@JsonProperty("apy") var apy:String?=null,
@ApiModelProperty("Extra reward asset.")
@JsonProperty("extraRewardAsset") var extraRewardAsset:String?=null,
@ApiModelProperty("Extra reward APY.")
@JsonProperty("extraRewardsAPY") var extraRewardsAPY:String?=null,
@ApiModelProperty("project.")
@JsonProperty("project") var project:String?=null)
{
}
