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
package com.binance4j.loan.client

import com.binance4j.core.client.RestClient
import com.binance4j.core.exception.ApiException
import com.binance4j.core.param.TimeFrame
import com.binance4j.core.test.CustomTest
import com.binance4j.loan.param.LoanIncomeHistoryParams
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class LoanClientTest : CustomTest() {
    protected var client = LoanClient(key, secret)

    init {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLoansIncome() {
        assertNotThrow(client.getLoansIncome(LoanIncomeHistoryParams(asset)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLoansIncome2() {
        assertNotThrow(client.getLoansIncome(LoanIncomeHistoryParams(asset), TimeFrame(25)))
    }
}