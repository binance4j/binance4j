/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.savings.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A fixed project position.
 *
 * @property asset           Asset.
 * @property canTransfer     Can transfer.
 * @property createTimestamp Create timestamp.
 * @property duration        Duration.
 * @property endTime         End time.
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
	@JsonProperty("asset")
	var asset: String,
	@ApiModelProperty("Can transfer.")
	@JsonProperty("canTransfer")
	var canTransfer: Boolean,
	@ApiModelProperty("Create timestamp.")
	@JsonProperty("createTimestamp")
	var createTimestamp: Long,
	@ApiModelProperty("Duration.")
	@JsonProperty("duration")
	var duration: Long,
	@ApiModelProperty("End time.")
	@JsonProperty("endTime")
	var endTime: Long,
	@ApiModelProperty("Interest.")
	@JsonProperty("interest")
	var interest: String,
	@ApiModelProperty("Interest rate.")
	@JsonProperty("interestRate")
	var interestRate: String,
	@ApiModelProperty("Lot.")
	@JsonProperty("lot")
	var lot: Long,
	@ApiModelProperty("Position id.")
	@JsonProperty("positionId")
	var positionId: Long,
	@ApiModelProperty("Principal.")
	@JsonProperty("principal")
	var principal: String,
	@ApiModelProperty("Project id.")
	@JsonProperty("projectId")
	var projectId: String,
	@ApiModelProperty("Project name.")
	@JsonProperty("projectName")
	var projectName: String,
	@ApiModelProperty("Purchase time.")
	@JsonProperty("purchaseTime")
	var purchaseTime: Long,
	@ApiModelProperty("Redeem date.")
	@JsonProperty("redeemDate")
	var redeemDate: String,
	@ApiModelProperty("Start time.")
	@JsonProperty("startTime")
	var startTime: Long,
	@ApiModelProperty("Status.")
	@JsonProperty("status")
	var status: String,
	@ApiModelProperty("Type.")
	@JsonProperty("type")
	var type: String
)