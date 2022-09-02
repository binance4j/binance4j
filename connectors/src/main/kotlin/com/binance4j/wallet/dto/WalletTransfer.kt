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

package com.binance4j.wallet.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A wallet to wallet transfer.
 *
 * @property asset Transferred asset.
 * @property amount Transferred amount.
 * @property type Transfer type (origin wallet to destination wallet).
 * @property status Transfer status.
 * @property tranId Transaction id.
 * @property timestamp Transfer timestamp.
 * @see WalletTransferType
 */
@ApiModel("A wallet to wallet transfer.")
data class WalletTransfer(
	@ApiModelProperty("Transferred asset.")
	var asset: String,
	@ApiModelProperty("Transferred amount.")
	var amount: String,
	@ApiModelProperty("Transfer type (origin wallet to destination wallet).")
	var type: String,
	@ApiModelProperty("Transfer status.")
	var status: String,
	@ApiModelProperty("Transaction id.")
	var tranId: Long,
	@ApiModelProperty("Transfer timestamp.")
	var timestamp: Long,
)
