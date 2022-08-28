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

package com.binance4j.blvt.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * A BLVT redemption.
 *
 * @property id          Id.
 * @property tokenName   Token name.
 * @property amount      Amount.
 * @property nav         Nav.
 * @property fee         Fee.
 * @property totalCharge Total charge.
 * @property timestamp   Timestamp in ms.
 */
@ApiModel(value = "A BLVT redemption.")
data class Redemption(
    @ApiModelProperty("Id.")
    var id: Long? = null,
    @ApiModelProperty("Token name.")
    var tokenName: String? = null,
    @ApiModelProperty("Amount.")
    var amount: String? = null,
    @ApiModelProperty("Nav.")
    var nav: String? = null,
    @ApiModelProperty("Fee.")
    var fee: String? = null,
    @ApiModelProperty("Total charge.")
    var totalCharge: String? = null,
    @ApiModelProperty("Timestamp in ms.")
    var timestamp: Long? = null
)

