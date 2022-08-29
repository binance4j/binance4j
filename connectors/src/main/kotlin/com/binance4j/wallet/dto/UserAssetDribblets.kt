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

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Dribblets.
 *
 * @property operateTime Operation timestamp.
 * @property totalTransferedAmount Total transfered BNB amount for this
 * ```
 *                                 exchange.
 * @property totalServiceChargeAmount
 * ```
 * Total service charge amount for this
 * ```
 *                                 exchange.
 * @property transId
 * ```
 * Transaction id.
 * @property userAssetDribbletDetails Details of this exchange.
 */
@ApiModel("Dribblets.")
data class UserAssetDribblets(
    @ApiModelProperty("Operation timestamp.") @JsonProperty("operateTime") var operateTime: Long = 0L,
    @ApiModelProperty("Total transfered BNB amount for this exchange.")
    @JsonProperty
    var totalTransferedAmount: String = "",
    @ApiModelProperty("Total service charge amount for this exchange.")
    @JsonProperty
    var totalServiceChargeAmount: String = "",
    @ApiModelProperty("Transaction id.") @JsonProperty("transId") var transId: Long = 0L,
    @ApiModelProperty("Details of this exchange.")
    @JsonProperty
    var userAssetDribbletDetails:List<UserAssetDribbletDetails> = emptyList()
)
