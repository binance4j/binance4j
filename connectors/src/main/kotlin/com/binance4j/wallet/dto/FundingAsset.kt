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
 * The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders,
 * Binance Payment, Binance Card and Crypto Deposit/Withdrawal.
 *
 * @property asset Asset abbreviation.
 * @property free Available balance.
 * @property locked Locked balance (volume in the order book).
 * @property freeze Frozen balance.
 * @property withdrawing Pending volume withdrawing.
 * @property btcValuation Value of the balance in BTC.
 */
@ApiModel(
    "The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders, Binance Payment, Binance Card and Crypto Deposit/Withdrawal."
)
data class FundingAsset(
    @ApiModelProperty("Asset abbreviation.") @JsonProperty("asset") var asset: String = "",
    @ApiModelProperty("Available balance.") @JsonProperty("free") var free: String = "",
    @ApiModelProperty("Locked balance (volume in the order book).")
    @JsonProperty
    var locked: String = "",
    @ApiModelProperty("Frozen balance.") @JsonProperty("freeze") var freeze: String = "",
    @ApiModelProperty("Pending volume withdrawing.")
    @JsonProperty
    var withdrawing: String = "",
    @ApiModelProperty("Value of the balance in BTC.")
    @JsonProperty
    var btcValuation: String = ""
)
