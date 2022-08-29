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
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Display priority.")
@JsonProperty("displayPriority") var displayPriority: Long = 0L,
@ApiModelProperty("Duration.")
@JsonProperty("duration") var duration: Long = 0L,
@ApiModelProperty("Interest per lot.")
@JsonProperty("interestPerLot") var interestPerLot: String = "",
@ApiModelProperty("Interest rate.")
@JsonProperty("interestRate") var interestRate: String = "",
@ApiModelProperty("Lot size.")
@JsonProperty("lotSize") var lotSize: String = "",
@ApiModelProperty("Lots low limit.")
@JsonProperty("lotsLowLimit") var lotsLowLimit: Long = 0L,
@ApiModelProperty("Lots purchased.")
@JsonProperty("lotsPurchased") var lotsPurchased: Long = 0L,
@ApiModelProperty("Lots up limit.")
@JsonProperty("lotsUpLimit") var lotsUpLimit: Long = 0L,
@ApiModelProperty("Max lots per user.")
@JsonProperty("maxLotsPerUser") var maxLotsPerUser: Long = 0L,
@ApiModelProperty("Need kyc.")
@JsonProperty("needKyc") var needKyc: Boolean = false,
@ApiModelProperty("Project id.")
@JsonProperty("projectId") var projectId: String = "",
@ApiModelProperty("Project name.")
@JsonProperty("projectName") var projectName: String = "",
@ApiModelProperty("Status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Type.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("With area limitation.") @JsonProperty("withAreaLimitation") var withAreaLimitation: Boolean = false)
{
}