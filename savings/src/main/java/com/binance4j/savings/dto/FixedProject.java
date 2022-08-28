package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Fixed or activity project.
 * 
 * @property asset              Asset.
 * @property displayPriority    Display priority.
 * @property duration           Duration.
 * @property interestPerLot     Interest per lot.
 * @property interestRate       Interest rate.
 * @property lotSize            Lot size.
 * @property lotsLowLimit       Lots low limit.
 * @property lotsPurchased      Lots purchased.
 * @property lotsUpLimit        Lots up limit.
 * @property maxLotsPerUser     Max lots per user.
 * @property needKyc            Need kyc.
 * @property projectId          Project id.
 * @property projectName        Project name.
 * @property status             Status.
 * @property type               Type.
 * @property withAreaLimitation With area limitation.
 */
@ApiModel("Fixed or activity project.")
data class FixedProject(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Display priority.")
@JsonProperty("displayPriority") var displayPriority:Long?=null,
@ApiModelProperty("Duration.")
@JsonProperty("duration") var duration:Long?=null,
@ApiModelProperty("Interest per lot.")
@JsonProperty("interestPerLot") var interestPerLot:String?=null,
@ApiModelProperty("Interest rate.")
@JsonProperty("interestRate") var interestRate:String?=null,
@ApiModelProperty("Lot size.")
@JsonProperty("lotSize") var lotSize:String?=null,
@ApiModelProperty("Lots low limit.")
@JsonProperty("lotsLowLimit") var lotsLowLimit:Long?=null,
@ApiModelProperty("Lots purchased.")
@JsonProperty("lotsPurchased") var lotsPurchased:Long?=null,
@ApiModelProperty("Lots up limit.")
@JsonProperty("lotsUpLimit") var lotsUpLimit:Long?=null,
@ApiModelProperty("Max lots per user.")
@JsonProperty("maxLotsPerUser") var maxLotsPerUser:Long?=null,
@ApiModelProperty("Need kyc.")
@JsonProperty("needKyc") var needKyc:Boolean?=null,
@ApiModelProperty("Project id.")
@JsonProperty("projectId") var projectId:String?=null,
@ApiModelProperty("Project name.")
@JsonProperty("projectName") var projectName:String?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null,
@ApiModelProperty("With area limitation.") @JsonProperty("withAreaLimitation") var withAreaLimitation:Boolean?=null)
{
}