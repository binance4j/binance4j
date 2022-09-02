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

import com.binance4j.core.dto.RateLimit
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * The current exchange trading rules and symbol information.
 *
 * @property timezone        Server timezone.
 * @property serverTime      Server time.
 * @property rateLimits      Request limits (weight, orders, raw...).
 * @property exchangeFilters Trading rules of the exchange.
 * @property symbols         Available symbols on the exchange.
 */
@ApiModel("The current exchange trading rules and symbol information.")
data class ExchangeInfo(
	@ApiModelProperty("Server timezone.")
	var timezone: String,
	@ApiModelProperty("Server time.")
	var serverTime: Long,
	@ApiModelProperty("Request limits (weight, orders, raw...).")
	var rateLimits: List<RateLimit>,
	@ApiModelProperty("Trading rules of the exchange.")
	var exchangeFilters: List<ExchangeFilter>,
	@ApiModelProperty("Available symbols on the exchange.")
	var symbols: List<SymbolInfo>,
) {
	/**
	 * @property symbol Symbol we want the info.
	 * @return The symbol exchange information.
	 */
	fun getSymbolInfo(symbol: String): SymbolInfo = symbols.first { symbolInfo -> symbolInfo.symbol == symbol }
}
