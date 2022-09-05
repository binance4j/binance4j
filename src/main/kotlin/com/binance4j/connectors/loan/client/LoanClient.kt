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
package com.binance4j.connectors.loan.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.loan.dto.LoanIncomeType

/**
 * Api client for the loan endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints)
 */
object LoanClient : RestClient<LoanMapping>(LoanMapping::class.java) {
	/**
	 * Get crypto loans income history.
	 *
	 * @param asset 	Asset we want the incomes.
	 * @param type  	Loan income type. All types will be returned by default.
	 * @param startTime Start time in ms.
	 * @param endTime   End time in ms.
	 * @param limit     Results limit.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getLoansIncome(asset: String, type: LoanIncomeType, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) = Request(service
		.getLoansIncome(asset, type.toString(), startTime, endTime, limit))
}