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
import com.binance4j.wallet.dto.WalletTransferType

/**
 * [WalletClient.getTransferHistory] params.
 *
 * @property type       User universal transfer type.
 * @property fromSymbol Mandatory when {@code ISOLATEDMARGIN_MARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 * @property toSymbol   Mandatory when {@code MARGIN_ISOLATEDMARGIN} and {@code ISOLATEDMARGIN_ISOLATEDMARGIN}.
 * @property startTime Start time in ms.
 * @property endTime   End time in ms.
 * @property page      Result page.
 * @property limit     Results in the page.
 */
data class WalletTransferHistoryParams @JvmOverloads constructor(
	var type: WalletTransferType,
	var fromSymbol: String? = null,
	var toSymbol: String? = null,
	var startTime: Long? = null,
	var endTime: Long? = null,
	var page: Int? = null,
	var limit: Int? = null
) : Params