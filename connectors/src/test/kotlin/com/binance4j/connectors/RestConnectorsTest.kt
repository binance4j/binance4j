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

package com.binance4j.connectors

import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RestConnectorsTest : CustomTest() {
    var connectors: Connectors

    init {
        connectors = Connectors(key, secret)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetBLVTClient() {
        Assertions.assertNotNull(connectors.rest.blvt())
    }

    @Test
    fun testGetC2CClient() {
        Assertions.assertNotNull(connectors.rest.c2c())
    }

    @Test
    fun testGetFiatClient() {
        Assertions.assertNotNull(connectors.rest.fiat())
    }

    @Test
    fun testGetLoanClient() {
        Assertions.assertNotNull(connectors.rest.loan())
    }

    @Test
    fun testGetMarginClient() {
        Assertions.assertNotNull(connectors.rest.margin())
    }

    @Test
    fun testGetMarketClient() {
        Assertions.assertNotNull(connectors.rest.market())
    }

    @Test
    fun testGetMiningClient() {
        Assertions.assertNotNull(connectors.rest.mining())
    }

    @Test
    fun testGetNFTClient() {
        Assertions.assertNotNull(connectors.rest.nft())
    }

    @Test
    fun testGetPayClient() {
        Assertions.assertNotNull(connectors.rest.pay())
    }

    @Test
    fun testGetPortfolioMarginClient() {
        Assertions.assertNotNull(connectors.rest.margin())
    }

    @Test
    fun testGetRebateClient() {
        Assertions.assertNotNull(connectors.rest.rebate())
    }

    @Test
    fun testGetSavingsClient() {
        Assertions.assertNotNull(connectors.rest.savings())
    }

    @Test
    fun testGetSpotClient() {
        Assertions.assertNotNull(connectors.rest.spot())
    }

    @Test
    fun testGetStakingClient() {
        Assertions.assertNotNull(connectors.rest.staking())
    }

    @Test
    fun testGetVisionSpotClient() {
        Assertions.assertNotNull(connectors.rest.visionSpot())
    }

    @Test
    fun testGetWalletClient() {
        Assertions.assertNotNull(connectors.rest.wallet())
    }

    @Test
    fun testUpdateKeys() {
        assertEquals(connectors.rest.key, connectors.rest.c2c().key)
        assertEquals(connectors.rest.secret, connectors.rest.blvt().secret)
        connectors.rest.updateKeys("foo", "bar")
        assertEquals(connectors.rest.key, connectors.rest.convert().key)
        assertEquals(connectors.rest.secret, connectors.rest.blvt().secret)
    }
}