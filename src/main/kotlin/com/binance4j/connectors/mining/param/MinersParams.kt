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

package com.binance4j.connectors.mining.param

import com.binance4j.connectors.core.param.Params
import com.binance4j.connectors.mining.client.MiningClient
import com.binance4j.connectors.mining.dto.WorkerStatus

/**
 * [MiningClient.getMiners] params.
 *
 * @param algo         Algorithm.
 * @param userName     Mining account.
 * @param pageIndex    Page number.
 * @param sort         Sort sequence.
 * @param sortColumn   Miner sort.
 * @param workerStatus Miner status.
 */
data class MinersParams @JvmOverloads constructor(
	var algo: String,
	var userName: String,
	var workerStatus: String? = null,
	var pageIndex: Int? = null,
	var sort: String? = null,
	var sortColumn: String? = null,
) : Params {
	@JvmOverloads
	constructor(
		algo: String,
		userName: String,
		workerStatus: WorkerStatus,
		pageIndex: Int? = null,
		sort: String? = null,
		sortColumn: String? = null,
	) : this(algo, userName, workerStatus.toString(), pageIndex, sort, sortColumn)
}