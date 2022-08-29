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
	val asset: String = "",
	
	@ApiModelProperty("Display priority.")
	val displayPriority: Long,
	
	@ApiModelProperty("Duration.")
	val duration: Long,
	
	@ApiModelProperty("Interest per lot.")
	val interestPerLot: String,
	
	@ApiModelProperty("Interest rate.")
	val interestRate: String,
	
	@ApiModelProperty("Lot size.")
	val lotSize: String,
	
	@ApiModelProperty("Lots low limit.")
	val lotsLowLimit: Long,
	
	@ApiModelProperty("Lots purchased.")
	val lotsPurchased: Long,
	
	@ApiModelProperty("Lots up limit.")
	val lotsUpLimit: Long,
	
	@ApiModelProperty("Max lots per user.")
	val maxLotsPerUser: Long,
	
	@ApiModelProperty("Need kyc.")
	val needKyc: Boolean,
	
	@ApiModelProperty("Project id.")
	val projectId: String,
	
	@ApiModelProperty("Project name.")
	val projectName: String,
	
	@ApiModelProperty("Status.")
	val status: String,
	
	@ApiModelProperty("Type.")
	val type: String,
	
	@ApiModelProperty("With area limitation.")
	val withAreaLimitation: Boolean
)