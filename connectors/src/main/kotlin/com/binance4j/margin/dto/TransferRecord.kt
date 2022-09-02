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

package com.binance4j.margin.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A transfer history record.
 *
 * @property txId                 Transaction id.
 * @property amount               Transferred amount.
 * @property asset                Transferred asset.
 * @property status               Transfer status.
 * @property timestamp            Transaction time in ms.
 * @property type                 Transfer history type.
 * @property transferCounterparty Transfer counterparty.
 * @property clientTag            Client tag.
 * @see TransferRecordType
 */
@ApiModel("A transfer history record.")
data class TransferRecord(
	@ApiModelProperty("Transaction id.")
	var txId: Long,
	@ApiModelProperty("Transfered amount.")
	var amount: String,
	@ApiModelProperty("Transfered asset.")
	var asset: String,
	@ApiModelProperty("Transfer status.")
	var status: String,
	@ApiModelProperty("Transaction time in ms.")
	var timestamp: Long,
	@ApiModelProperty("Transfer history type.")
	var type: String,
	@ApiModelProperty("Transfer counterparty.")
	var transferCounterparty: String,
	@ApiModelProperty("Client tag.")
	var clientTag: String
) 