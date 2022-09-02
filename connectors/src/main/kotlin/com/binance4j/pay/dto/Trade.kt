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

package com.binance4j.pay.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Pay transaction.
 *
 * @property transactionId   Transaction id.
 * @property transactionTime Transaction time in ms.
 * @property amount          Transaction amount.
 * @property currency        Transaction asset.
 * @property fundsDetail     Funds details.
 * @property orderType       Order type.
 * @see OrderType
 */
@ApiModel("Pay transaction.")
data class Trade(
	@ApiModelProperty("Transaction id.")
	var orderType: String,
	@ApiModelProperty("Transaction time in ms.")
	var transactionId: String,
	@ApiModelProperty("Transaction amount.")
	var transactionTime: Long,
	@ApiModelProperty("Transaction asset.")
	var amount: String,
	@ApiModelProperty("Funds details.")
	var currency: String,
	@ApiModelProperty("Order type. PAY: C2B Merchant Acquiring Payment. PAY_REFUND: C2B Merchant Acquiring Payment,refund. C2C: C2C Transfer Payment. CRYPTO_BOX: Crypto box. CRYPTO_BOX_RF: Crypto Box, refund. C2C_HOLDING: Transfer to new Binance user. C2C_HOLDING_RF: Transfer to new Binance user,refund. PAYOUT: B2C Disbursement Payment. ")
	var fundsDetail: List<FundsDetail> = emptyList()
)