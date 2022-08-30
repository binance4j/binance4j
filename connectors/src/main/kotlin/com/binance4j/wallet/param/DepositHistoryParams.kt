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

package com.binance4j.wallet.param


import com.binance4j.core.param.Params
import com.binance4j.wallet.client.WalletClient
import com.binance4j.wallet.dto.DepositStatus

/**
 * [WalletClient.getDepositHistory] params.
 *
 * @param coin   Deposited coin.
 * @param status Deposit status. 0:pending, 1:success,6: credited but cannot withdraw.
 */
data class DepositHistoryParams @JvmOverloads constructor(
	var coin: String? = null,
	var status: String? = null,
	var startTime: Long? = null,
	var endTime: Long? = null,
	var page: Int? = null,
	var limit: Int? = null
) : Params {
	@JvmOverloads
	constructor(
		coin: String,
		status: DepositStatus,
		startTime: Long? = null,
		endTime: Long? = null,
		page: Int? = null,
		limit: Int? = null
	) : this(coin, status.toString(), startTime, endTime, page, limit)
	
	@JvmOverloads
	constructor (
		status: DepositStatus,
		startTime: Long? = null,
		endTime: Long? = null,
		page: Int? = null,
		limit: Int? = null
	) : this(null, status.toString(), startTime, endTime, page, limit)
}