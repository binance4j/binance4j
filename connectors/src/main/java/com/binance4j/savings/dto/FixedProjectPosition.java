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
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Can transfer.")
@JsonProperty("canTransfer") var canTransfer: Boolean = false,
@ApiModelProperty("Create timestamp.")
@JsonProperty("createTimestamp") var createTimestamp: Long = 0L,
@ApiModelProperty("Duration.")
@JsonProperty("duration") var duration: Long = 0L,
@ApiModelProperty("Endtime.")
@JsonProperty("endTime") var endTime: Long = 0L,
@ApiModelProperty("Interest.")
@JsonProperty("interest") var interest: String = "",
@ApiModelProperty("Interest rate.")
@JsonProperty("interestRate") var interestRate: String = "",
@ApiModelProperty("Lot.")
@JsonProperty("lot") var lot: Long = 0L,
@ApiModelProperty("Position id.")
@JsonProperty("positionId") var positionId: Long = 0L,
@ApiModelProperty("Principal.")
@JsonProperty("principal") var principal: String = "",
@ApiModelProperty("Project id.")
@JsonProperty("projectId") var projectId: String = "",
@ApiModelProperty("Project name.")
@JsonProperty("projectName") var projectName: String = "",
@ApiModelProperty("Purchase time.")
@JsonProperty("purchaseTime") var purchaseTime: Long = 0L,
@ApiModelProperty("Redeem date.")
@JsonProperty("redeemDate") var redeemDate: String = "",
@ApiModelProperty("Start time.")
@JsonProperty("startTime") var startTime: Long = 0L,
@ApiModelProperty("Status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Type.")
@JsonProperty("type") var type: String = "")
{
}
