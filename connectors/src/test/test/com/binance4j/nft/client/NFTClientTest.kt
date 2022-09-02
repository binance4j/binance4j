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
package com.binance4j.nft.client

import com.binance4j.connectors.Connectors
import com.binance4j.core.param.FramedPaging
import com.binance4j.core.param.Paging
import com.binance4j.core.test.CustomTest
import com.binance4j.nft.dto.OrderType
import com.binance4j.nft.param.TransactionHistoryParams
import org.junit.jupiter.api.Test

class NFTClientTest : CustomTest() {
	private var page = 1
	private val client
		get() = Connectors.`rest()`.updateKeys(key, secret).nft()
	
	@Test
	fun testGetAssets() {
		assertNotThrow(client.getAssets())
	}
	
	@Test
	fun testGetAssets2() {
		assertNotThrow(client.getAssets(Paging(1)))
	}
	
	@Test
	fun testGetDeposits() {
		assertNotThrow(client.getDeposits())
	}
	
	@Test
	fun testGetDeposits2() {
		assertNotThrow(client.getDeposits(FramedPaging(page.toLong())))
	}
	
	@Test
	fun testGetTransactions() {
		for (o in OrderType.values()) {
			assertNotThrow(client.getTransactions(TransactionHistoryParams(o)))
		}
	}
	
	@Test
	fun testGetTransactions2() {
		assertNotThrow(
			client.getTransactions(
				TransactionHistoryParams(OrderType.SELL_ORDER),
				FramedPaging(page.toLong())
			)
		)
	}
	
	@Test
	fun testGetWithdraws() {
		assertNotThrow(client.getWithdraws())
	}
	
	@Test
	fun testGetWithdraws2() {
		assertNotThrow(client.getWithdraws(FramedPaging(1)))
	}
}