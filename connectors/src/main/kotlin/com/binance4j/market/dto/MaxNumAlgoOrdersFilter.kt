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

package com.binance4j.market.dto

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The maximum number of orders an account is allowed to have open on a symbol.
 * Note that both "algo" orders and normal
 * orders are counted for this filter.
 *
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 * @property maxNumAlgoOrders Maximum number of "algo" orders an account is allowed
 *                         to have open on a symbol. "Algo".
 *                         orders are {@code STOP_LOSS} {@code STOP_LOSS_LIMIT}
 *                         {@code TAKE_PROFIT} and
 *                         {@code TAKE_PROFIT_LIMIT} orders.
 */
@ApiModel("The maximum number of orders an account is allowed to have open on a symbol.")
data class MaxNumAlgoOrdersFilter(
	@ApiModelProperty("The maximum number of \"algo\" orders an account is allowed to have open on a symbol.")
	var maxNumAlgoOrders: String
)