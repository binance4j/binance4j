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

package com.binance4j.blvt.client

import com.binance4j.blvt.param.*
import com.binance4j.core.exception.ApiException
import com.binance4j.core.param.TimeFrame
import com.binance4j.core.test.CustomTest
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class BLVTClientTest : CustomTest() {
    private var client = BLVTClient(key, secret)
    private var timeFrame = TimeFrame(limit)
    private var tokenName = "1INCHDOWN"
    private var amount = "1"

    init {
        client.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
        client.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLimitInfo() {
        testNotThrow(client.getLimitInfo())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLimitInfo2() {
        testNotThrow(client.getLimitInfo(LimitInfoParams(tokenName)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetRedemptions() {
        testNotThrow(client.getRedemptions())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetRedemptionsWithTimeFrame() {
        testNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L), timeFrame))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSubscriptions() {
        testNotThrow(client.getSubscriptions())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSubscriptionsWithTimeFrame() {
        testNotThrow(client.getSubscriptions(TransactionRecordParams(tokenName), timeFrame))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTokenInfo() {
        testNotThrow(client.getTokenInfo())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTokenInfoWithParams() {
        testNotThrow(client.getTokenInfo(TokenInfoParams(tokenName)))
    }

    // NOT TEST DUE TO NEW FRENCH LAWS
    // TODO @Test
    @Throws(ApiException::class)
    fun testRedeem() {
        testNotThrow(client.redeem(RedemptionParams(tokenName, amount)))
    }

    // TODO @Test
    @Throws(ApiException::class)
    fun testSubscribe() {
        testNotThrow(client.subscribe(SubscriptionParams(tokenName, amount)))
    }

    // TODO @Test
    @Throws(ApiException::class)
    fun testGetRedemptionsWithParams() {
        testNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L)))
    }
}