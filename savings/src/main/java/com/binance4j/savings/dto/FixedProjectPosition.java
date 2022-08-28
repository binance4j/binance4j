package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A fixed project position.
 * 
 * @property asset           Asset.
 * @property canTransfer     Can transfer.
 * @property createTimestamp Create timestamp.
 * @property duration        Duration.
 * @property endTime         Endtime.
 * @property interest        Interest.
 * @property interestRate    Interest rate.
 * @property lot             Lot.
 * @property positionId      Position id.
 * @property principal       Principal.
 * @property projectId       Project id.
 * @property projectName     Project name.
 * @property purchaseTime    Purchase time.
 * @property redeemDate      Redeem date.
 * @property startTime       Start time.
 * @property status          Status.
 * @property type            Type.
 */
@ApiModel("A fixed project position.")
data class FixedProjectPosition(
@ApiModelProperty("Asset.")
var asset:String?=null,
@ApiModelProperty("Can transfer.")
var canTransfer:Boolean?=null,
@ApiModelProperty("Create timestamp.")
var createTimestamp:Long?=null,
@ApiModelProperty("Duration.")
var duration:Long?=null,
@ApiModelProperty("Endtime.")
var endTime:Long?=null,
@ApiModelProperty("Interest.")
var interest:String?=null,
@ApiModelProperty("Interest rate.")
var interestRate:String?=null,
@ApiModelProperty("Lot.")
var lot:Long?=null,
@ApiModelProperty("Position id.")
var positionId:Long?=null,
@ApiModelProperty("Principal.")
var principal:String?=null,
@ApiModelProperty("Project id.")
var projectId:String?=null,
@ApiModelProperty("Project name.")
var projectName:String?=null,
@ApiModelProperty("Purchase time.")
var purchaseTime:Long?=null,
@ApiModelProperty("Redeem date.")
var redeemDate:String?=null,
@ApiModelProperty("Start time.")
var startTime:Long?=null,
@ApiModelProperty("Status.")
var status:String?=null,
@ApiModelProperty("Type.")
var type:String?=null)
{
}
