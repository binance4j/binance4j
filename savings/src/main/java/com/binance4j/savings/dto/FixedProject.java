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
var asset:String?=null,
@ApiModelProperty("Display priority.")
var displayPriority:Long?=null,
@ApiModelProperty("Duration.")
var duration:Long?=null,
@ApiModelProperty("Interest per lot.")
var interestPerLot:String?=null,
@ApiModelProperty("Interest rate.")
var interestRate:String?=null,
@ApiModelProperty("Lot size.")
var lotSize:String?=null,
@ApiModelProperty("Lots low limit.")
var lotsLowLimit:Long?=null,
@ApiModelProperty("Lots purchased.")
var lotsPurchased:Long?=null,
@ApiModelProperty("Lots up limit.")
var lotsUpLimit:Long?=null,
@ApiModelProperty("Max lots per user.")
var maxLotsPerUser:Long?=null,
@ApiModelProperty("Need kyc.")
var needKyc:Boolean?=null,
@ApiModelProperty("Project id.")
var projectId:String?=null,
@ApiModelProperty("Project name.")
var projectName:String?=null,
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Type.")
var type:String?=null,
@ApiModelProperty("With area limitation.") var withAreaLimitation:Boolean?=null)
{
}