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
var positionId:String?=null,
@ApiModelProperty("Time.")
var time:String?=null,
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Project.")
var project:String?=null,
@ApiModelProperty("Amount.")
var amount:String?=null,
@ApiModelProperty("Lock period.")
var lockPeriod:String?=null,
@ApiModelProperty("Deliver date.")
var deliverDate:String?=null,
@ApiModelProperty("Type.")
var type:String?=null,
@ApiModelProperty("Status.")
var status:String?=null)
{
}
