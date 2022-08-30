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

package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.borrow] params.
 * 
 * @param asset      Asset to borrow.
 * @param amount     Amount to borrow.
 * @param symbol     Isolated symbol.
 * @param isIsolated For isolated margin or not. Default: false.
 */
data class BorrowParams(
asset : String, String amount,
symbol : String, Boolean isIsolated):Params
{

	/**
	 * Creates an instance of {@link BorrowParams}.
	 * 
	 * @param asset      Asset to borrow.
	 * @param amount     Amount to borrow.
	 * @param symbol     Isolated symbol.
	 * @param isIsolated For isolated margin or not. Default: false.
	 */
	public BorrowParams(String asset, String amount, String symbol, Boolean isIsolated) {
		this.asset = asset;
		this.amount = amount;
		this.symbol = symbol;
		this.isIsolated = isIsolated;
	}

	/**
	 * Creates an instance of {@link BorrowParams}.
	 * 
	 * @param asset  Asset to borrow.
	 * @param amount Amount to borrow.
	 */
	public BorrowParams(String asset, String amount) {
		this(asset, amount, null, null);
	}
}