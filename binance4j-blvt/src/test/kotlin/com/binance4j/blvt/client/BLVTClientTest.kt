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
import com.binance4j.core.param.TimeFrame
import com.binance4j.core.test.CustomTest
import org.junit.jupiter.api.Test

class BLVTClientTest : CustomTest() {
    private var client = BLVTClient(key, secret)
    private var timeFrame = TimeFrame(limit = limit)
    private var tokenName = "1INCHDOWN"
    private var amount = "1"

    @Test
    fun testGetLimitInfo() {
        assertNotThrow(client.getLimitInfo())
    }

    @Test
    fun testGetLimitInfo2() {
        assertNotThrow(client.getLimitInfo(LimitInfoParams(tokenName)))
    }

    @Test
    fun testGetRedemptions() {
        assertNotThrow(client.getRedemptions())
    }

    @Test
    fun testGetRedemptionsWithTimeFrame() {
        assertNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L), timeFrame))
    }

    @Test
    fun testGetSubscriptions() {
        assertNotThrow(client.getSubscriptions())
    }

    @Test
    fun testGetSubscriptionsWithTimeFrame() {
        assertNotThrow(client.getSubscriptions(TransactionRecordParams(tokenName), timeFrame))
    }

    @Test
    fun testGetTokenInfo() {
        assertNotThrow(client.getTokenInfo())
    }

    @Test
    fun testGetTokenInfoWithParams() {
        assertNotThrow(client.getTokenInfo(TokenInfoParams(tokenName)))
    }

    // NOT TEST DUE TO NEW FRENCH LAWS
    // TODO @Test
    fun testRedeem() {
        assertNotThrow(client.redeem(RedemptionParams(tokenName, amount)))
    }

    // TODO @Test
    fun testSubscribe() {
        assertNotThrow(client.subscribe(SubscriptionParams(tokenName, amount)))
    }

    // TODO @Test
    fun testGetRedemptionsWithParams() {
        assertNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L)))
    }
}