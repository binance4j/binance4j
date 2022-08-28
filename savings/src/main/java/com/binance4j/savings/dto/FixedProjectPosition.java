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
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Can transfer.")
@JsonProperty("canTransfer") var canTransfer:Boolean?=null,
@ApiModelProperty("Create timestamp.")
@JsonProperty("createTimestamp") var createTimestamp:Long?=null,
@ApiModelProperty("Duration.")
@JsonProperty("duration") var duration:Long?=null,
@ApiModelProperty("Endtime.")
@JsonProperty("endTime") var endTime:Long?=null,
@ApiModelProperty("Interest.")
@JsonProperty("interest") var interest:String?=null,
@ApiModelProperty("Interest rate.")
@JsonProperty("interestRate") var interestRate:String?=null,
@ApiModelProperty("Lot.")
@JsonProperty("lot") var lot:Long?=null,
@ApiModelProperty("Position id.")
@JsonProperty("positionId") var positionId:Long?=null,
@ApiModelProperty("Principal.")
@JsonProperty("principal") var principal:String?=null,
@ApiModelProperty("Project id.")
@JsonProperty("projectId") var projectId:String?=null,
@ApiModelProperty("Project name.")
@JsonProperty("projectName") var projectName:String?=null,
@ApiModelProperty("Purchase time.")
@JsonProperty("purchaseTime") var purchaseTime:Long?=null,
@ApiModelProperty("Redeem date.")
@JsonProperty("redeemDate") var redeemDate:String?=null,
@ApiModelProperty("Start time.")
@JsonProperty("startTime") var startTime:Long?=null,
@ApiModelProperty("Status.")
@JsonProperty("status") var status:String?=null,
@ApiModelProperty("Type.")
@JsonProperty("type") var type:String?=null)
{
}
