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

package com.binance4j.mining.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A miner/worker data.
 *
 * @property workerId      Miner id.
 * @property workerName    Miner's name'.
 * @property status        Status：1 valid,2 invalid, 3 no longer valid.
 * @property hashRate      Real-time rate.
 * @property dayHashRate   24H Hash rate.
 * @property rejectRate    Real-time Rejection Rate.
 * @property lastShareTime Last submission time.
 */
@ApiModel("A miner/worker data.")
data class Worker(
	@ApiModelProperty("Miner id.")
	var workerId: String,
	@ApiModelProperty("Miner's name'.")
	var workerName: String,
	@ApiModelProperty("Status：1 valid,2 invalid, 3 no longer valid.")
	var status: Long,
	@ApiModelProperty("Real-time rate.")
	var hashRate: Long,
	@ApiModelProperty("24H Hashrate.")
	var dayHashRate: Long,
	@ApiModelProperty("Real-time Rejection Rate.")
	var rejectRate: Long,
	@ApiModelProperty("Last submission time.")
	var lastShareTime: Long
)