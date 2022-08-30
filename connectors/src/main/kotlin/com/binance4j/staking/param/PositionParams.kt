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

package com.binance4j.staking.param

import com.binance4j.core.param.Params
import com.binance4j.staking.client.StakingClient
import com.binance4j.staking.dto.ProductType

/**
 * [StakingClient.getPosition] params.
 *
 * @param product   Product type.
 * @param productId Product id.
 * @param asset     Product name.
 * @param current   Results page.
 * @param size      Number of rows.
 */
data class PositionParams @JvmOverloads constructor(
	var product: String? = null,
	var productId: String? = null,
	var asset: String? = null,
	var current: Int? = null,
	var size: Int? = null
) : Params {
	@JvmOverloads
	constructor(
		product: ProductType, productId: String? = null, asset: String? = null, current: Int? = null, size: Int? = null
	) : this(
		product.toString(),
		productId,
		asset,
		current,
		size
	)
}