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

package com.binance4j.staking.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Staking product detail.
 *
 * @property asset            Asset.
 * @property rewardAsset      Reward Asset.
 * @property duration         Duration in ms.
 * @property renewable        Renewable.
 * @property apy              Apy.
 * @property extraRewardAsset Extra reward asset.
 * @property extraRewardsAPY  Extra reward APY.
 * @property project          project.
 */
@ApiModel("Staking product detail.")
data class ProductDetail(
	@ApiModelProperty("Asset.")
	val asset: String,
	@ApiModelProperty("Reward Asset.")
	val rewardAsset: String,
	@ApiModelProperty("Duration in ms.")
	val duration: Int,
	@ApiModelProperty("Renewable.")
	val renewable: Boolean,
	@ApiModelProperty("Apy.")
	val apy: String,
	@ApiModelProperty("Extra reward asset.")
	val extraRewardAsset: String,
	@ApiModelProperty("Extra reward APY.")
	val extraRewardsAPY: String,
	@ApiModelProperty("project.")
	val project: String
)
