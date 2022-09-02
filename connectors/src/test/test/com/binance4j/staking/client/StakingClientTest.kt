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
package com.binance4j.staking.client

import com.binance4j.connectors.Connectors
import com.binance4j.core.Binance4j
import com.binance4j.core.test.CustomTest
import com.binance4j.staking.dto.ProductType
import com.binance4j.staking.dto.TransactionType
import com.binance4j.staking.param.HistoryParams
import com.binance4j.staking.param.LeftQuotaParams
import com.binance4j.staking.param.PositionParams
import com.binance4j.staking.param.ProductListParams
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class StakingClientTest : CustomTest() {
	private var productId = "Cake*120"
	private val client: StakingClient
		get() = Connectors.`rest()`.updateKeys(key, secret).staking()
	
	@Test
	fun testGetHistory() {
		ProductType.values().forEach { product ->
			TransactionType.values().forEach { transaction ->
				assertNotThrow(client.getHistory(HistoryParams(product, transaction)))
			}
		}
	}
	
	@Test
	fun testGetLeftQuota() {
		ProductType.values()
			.forEach { product -> assertNotThrow(client.getLeftQuota(LeftQuotaParams(product, productId))) }
	}
	
	@Test
	fun testGetPosition() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		ProductType.values().forEach { product -> assertNotThrow(client.getPosition(PositionParams(product))) }
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	fun testGetProducts() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		ProductType.values().forEach { product -> assertNotThrow(client.getProducts(ProductListParams(product))) }
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
}