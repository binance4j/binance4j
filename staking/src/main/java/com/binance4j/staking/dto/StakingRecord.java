package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Staking record.
 * 
 * @property positionId  Position id.
 * @property time        Time.
 * @property asset       Asset.
 * @property project     Project.
 * @property amount      Amount.
 * @property lockPeriod  Lock period.
 * @property deliverDate Deliver date.
 * @property type        Type.
 * @property status      Status.
 */
@ApiModel("Staking record.")
data class StakingRecord(
@ApiModelProperty("Position id.")
@JsonProperty("positionId") var positionId:String?=null,
@ApiModelProperty("Time.")
@JsonProperty("time") var time:String?=null,
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Project.")
@JsonProperty("project") var project:String?=null,
@ApiModelProperty("Amount.")
@JsonProperty("amount") var amount:String?=null,
@ApiModelProperty("Lock period.")
@JsonProperty("lockPeriod") var lockPeriod:String?=null,
@ApiModelProperty("Deliver date.")
@JsonProperty("deliverDate") var deliverDate:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null)
{
}
