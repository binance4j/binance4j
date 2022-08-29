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
        Assertions.assertNotNull(connectors.REST.blvt())
    }

    @Test
    fun testGetC2CClient() {
        Assertions.assertNotNull(connectors.REST.c2c())
    }

    @Test
    fun testGetFiatClient() {
        Assertions.assertNotNull(connectors.REST.fiat())
    }

    @Test
    fun testGetLoanClient() {
        Assertions.assertNotNull(connectors.REST.loan())
    }

    @Test
    fun testGetMarginClient() {
        Assertions.assertNotNull(connectors.REST.margin())
    }

    @Test
    fun testGetMarketClient() {
        Assertions.assertNotNull(connectors.REST.market())
    }

    @Test
    fun testGetMiningClient() {
        Assertions.assertNotNull(connectors.REST.mining())
    }

    @Test
    fun testGetNFTClient() {
        Assertions.assertNotNull(connectors.REST.nft())
    }

    @Test
    fun testGetPayClient() {
        Assertions.assertNotNull(connectors.REST.pay())
    }

    @Test
    fun testGetPortfolioMarginClient() {
        Assertions.assertNotNull(connectors.REST.margin())
    }

    @Test
    fun testGetRebateClient() {
        Assertions.assertNotNull(connectors.REST.rebate())
    }

    @Test
    fun testGetSavingsClient() {
        Assertions.assertNotNull(connectors.REST.savings())
    }

    @Test
    fun testGetSpotClient() {
        Assertions.assertNotNull(connectors.REST.spot())
    }

    @Test
    fun testGetStakingClient() {
        Assertions.assertNotNull(connectors.REST.staking())
    }

    @Test
    fun testGetVisionSpotClient() {
        Assertions.assertNotNull(connectors.REST.visionSpot())
    }

    @Test
    fun testGetWalletClient() {
        Assertions.assertNotNull(connectors.REST.wallet())
    }

    @Test
    fun testUpdateKeys() {
        assertEquals(connectors.REST.key, connectors.REST.c2c().key)
        assertEquals(connectors.REST.secret, connectors.REST.blvt().secret)
        connectors.REST.updateKeys("foo", "bar")
        assertEquals(connectors.REST.key, connectors.REST.convert().key)
        assertEquals(connectors.REST.secret, connectors.REST.blvt().secret)
    }
}