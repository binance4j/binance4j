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

import com.binance4j.core.test.CustomTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RestConnectorsTest : CustomTest() {
	@Test
	fun testGetBLVTClient() {
		Assertions.assertNotNull(Connectors.rest(key, secret).blvt())
	}
	
	@Test
	fun testGetC2CClient() {
		Assertions.assertNotNull(Connectors.rest().c2c())
	}
	
	@Test
	fun testGetFiatClient() {
		Assertions.assertNotNull(Connectors.rest().fiat())
	}
	
	@Test
	fun testGetLoanClient() {
		Assertions.assertNotNull(Connectors.rest().loan())
	}
	
	@Test
	fun testGetMarginClient() {
		Assertions.assertNotNull(Connectors.rest().margin())
	}
	
	@Test
	fun testGetMarketClient() {
		Assertions.assertNotNull(Connectors.rest().market())
	}
	
	@Test
	fun testGetMiningClient() {
		Assertions.assertNotNull(Connectors.rest().mining())
	}
	
	@Test
	fun testGetNFTClient() {
		Assertions.assertNotNull(Connectors.rest().nft())
	}
	
	@Test
	fun testGetPayClient() {
		Assertions.assertNotNull(Connectors.rest().pay())
	}
	
	@Test
	fun testGetPortfolioMarginClient() {
		Assertions.assertNotNull(Connectors.rest().margin())
	}
	
	@Test
	fun testGetRebateClient() {
		Assertions.assertNotNull(Connectors.rest().rebate())
	}
	
	@Test
	fun testGetSavingsClient() {
		Assertions.assertNotNull(Connectors.rest().savings())
	}
	
	@Test
	fun testGetSpotClient() {
		Assertions.assertNotNull(Connectors.rest().spot())
	}
	
	@Test
	fun testGetStakingClient() {
		Assertions.assertNotNull(Connectors.rest().staking())
	}
	
	@Test
	fun testGetVisionSpotClient() {
		Assertions.assertNotNull(Connectors.rest().visionSpot())
	}
	
	@Test
	fun testGetWalletClient() {
		Assertions.assertNotNull(Connectors.rest().wallet())
	}
	
	@Test
	fun testUpdateKeys() {
		assertEquals(Connectors.rest().key, Connectors.rest().c2c().key)
		assertEquals(Connectors.rest().secret, Connectors.rest().blvt().secret)
		Connectors.rest().updateKeys("foo", "bar")
		assertEquals(Connectors.rest().key, Connectors.rest().convert().key)
		assertEquals(Connectors.rest().secret, Connectors.rest().blvt().secret)
	}
}