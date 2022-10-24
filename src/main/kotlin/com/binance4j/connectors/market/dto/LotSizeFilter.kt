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

package com.binance4j.connectors.market.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The quantity (aka "lots" in auction terms) rules for a symbol.
 *
 * @property minQty   Minimum quantity/iceberg Quantity allowed.
 * @property maxQty   Maximum quantity/iceberg Quantity allowed.
 * @property stepSize Intervals that a quantity/iceberg Quantity can be
 *                 increased/decreased by.
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#filters)
 */
@ApiModel("The quantity (aka `lots` in auction terms) rules for a symbol.")
data class LotSizeFilter(
    @ApiModelProperty("Minimum quantity/iceberg Quantity allowed.")
    @JsonProperty("minQty")
    override var minQty: String,
    @ApiModelProperty("Maximum quantity/iceberg Quantity allowed.")
    @JsonProperty("maxQty")
    override var maxQty: String,
    @ApiModelProperty("Intervals that a quantity/iceberg Quantity can be increased/decreased by.")
    @JsonProperty("stepSize")
    override var stepSize: String
) : BaseLotSizeFilter