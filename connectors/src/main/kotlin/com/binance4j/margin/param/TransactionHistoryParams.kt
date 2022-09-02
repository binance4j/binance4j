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

package com.binance4j.margin.param

import com.binance4j.core.param.Params


/**
 * [MarginClient.getInterestHistory],[MarginClient.getTransferHistory],[MarginClient.getLoanRecord],[MarginClient.getRepayRecord]
 * params.
 *
 * @param asset             Related asset.
 * @param isolatedSymbol    Isolated symbol.
 * @param txId              Transaction id in POST /sapi/v1/margin/repay.
 * @param archived          Set to true for archived data from 6 months ago.
 * @param startTime         Start time in ms.
 * @param endTime           End time in ms.
 * @param current           Result page.
 * @param size              Results in the page.
 */
data class TransactionHistoryParams(
	var asset: String? = null,
	var isolatedSymbol: String? = null,
	var txId: Long? = null,
	var archived: Boolean? = null,
	var startTime: Long? = null,
	var endTime: Long? = null,
	var current: Int? = null,
	var size: Int? = null
) : Params