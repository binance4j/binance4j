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

package com.binance4j.savings.dto

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
	var asset: String,
	@ApiModelProperty("Can transfer.")
	var canTransfer: Boolean,
	@ApiModelProperty("Create timestamp.")
	var createTimestamp: Long,
	@ApiModelProperty("Duration.")
	var duration: Long,
	@ApiModelProperty("End time.")
	var endTime: Long,
	@ApiModelProperty("Interest.")
	var interest: String,
	@ApiModelProperty("Interest rate.")
	var interestRate: String,
	@ApiModelProperty("Lot.")
	var lot: Long,
	@ApiModelProperty("Position id.")
	var positionId: Long,
	@ApiModelProperty("Principal.")
	var principal: String,
	@ApiModelProperty("Project id.")
	var projectId: String,
	@ApiModelProperty("Project name.")
	var projectName: String,
	@ApiModelProperty("Purchase time.")
	var purchaseTime: Long,
	@ApiModelProperty("Redeem date.")
	var redeemDate: String,
	@ApiModelProperty("Start time.")
	var startTime: Long,
	@ApiModelProperty("Status.")
	var status: String,
	@ApiModelProperty("Type.")
	var type: String
)