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

/**
 * Filters define trading rules on a symbol or an exchange. Filters come in two
 * forms: symbol filters and exchange
 * filters.
 */
enum class ExchangeFilterType {
	/**
	 * The `EXCHANGE_MAX_NUM_ORDERS` filter The maximum number of orders an
	 * account is allowed to have open on the
	 * exchange. Note that both "algo" orders and normal orders are counted for this
	 * filter.
	 */
	EXCHANGE_MAX_NUM_ORDERS,
	
	/**
	 * The `EXCHANGE_MAX_NUM_ALGO_ORDERS` filter The maximum number of "algo"
	 * orders an account is allowed to have
	 * open on the exchange. "Algo" orders are `STOP_LOSS`,
	 * `STOP_LOSS_LIMIT`, `TAKE_PROFIT`, and
	 * `TAKE_PROFIT_LIMIT` orders.
	 */
	EXCHANGE_MAX_NUM_ALGO_ORDERS,
}