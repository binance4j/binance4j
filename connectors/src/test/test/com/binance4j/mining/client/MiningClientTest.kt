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
package com.binance4j.mining.client

import com.binance4j.core.Binance4j
import com.binance4j.core.test.CustomTest
import com.binance4j.mining.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class MiningClientTest : CustomTest() {
	private var algo = "sha256"
	private var configId = 123
	private var userName = "vivienld"
	private var workerName = "vivienld.001"
	private var toPoolUser = "toPoolUser"
	private var endDate = System.currentTimeMillis()
	private var startDate = System.currentTimeMillis() - 365L * 24 * 60 * 60 * 1000
	private var hashRate = 0L
	var client = MiningClient(key, secret)
	
	init {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	
	fun testGetAccounts() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getAccounts(AccountListParams(algo, userName)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	
	fun testGetAlgorithms() {
		assertNotThrow(client.getAlgorithms())
	}
	
	@Test
	
	fun testGetCoins() {
		assertNotThrow(client.getCoins())
	}
	
	@Test
	
	fun testGetStatistics() {
		assertNotThrow(client.getStatistics(StatisticsParams(algo, userName)))
	}
	
	// NOT TESTED SINCE I DON'T MINE
	// TODO @Test
	fun testResellHashrate() {
		assertNotThrow(
			client
				.resellHashrate(HashrateResaleParams(userName, algo, endDate, startDate, toPoolUser, hashRate))
		)
	}
	
	// TODO @Test
	fun testCancelHashrateResaleConfiguration() {
		assertNotThrow(
			client
				.cancelHashrateResaleConfiguration(HashrateResaleCancellationParams(configId, userName))
		)
	}
	
	// TODO @Test
	fun testGetAccountProfits() {
		assertNotThrow(client.getAccountProfits(AccountProfitsParams(algo, userName)))
	}
	
	// TODO @Test
	fun testGetAccountProfitsFramed() {
		assertNotThrow(client.getAccountProfits(AccountProfitsParams(algo, userName, startDate, endDate)))
	}
	
	// TODO @Test
	fun testGetHashrateResales() {
		assertNotThrow(client.getHashrateResales())
	}
	
	// TODO @Test
	fun testGetHashrateResales2() {
		assertNotThrow(client.getHashrateResales(HashrateResaleListParams(pageIndex = 1, pageSize = limit)))
	}
	
	// TODO @Test
	fun testGetHashrateResalesDetails() {
		assertNotThrow(client.getHashrateResalesDetails(HashrateResaleDetailParam(configId, userName)))
	}
	
	// TODO @Test
	fun testGetHashrateResalesDetails2() {
		assertNotThrow(
			client.getHashrateResalesDetails(
				HashrateResaleDetailParam(
					configId,
					userName,
					pageIndex = 1,
					pageSize = limit
				)
			)
		)
	}
	
	// TODO @Test
	fun testGetMiners() {
		assertNotThrow(client.getMiners(MinersParams(algo, userName)))
	}
	
	// TODO @Test
	fun testGetMinersDetails() {
		assertNotThrow(client.getMinersDetails(MinerDetailsParams(algo, userName, workerName)))
	}
	
	// TODO @Test
	fun testGetOtherProfits() {
		assertNotThrow(client.getOtherProfits(ProfitsParams(algo, userName, pageIndex = 0, pageSize = limit)))
	}
	
	// TODO @Test
	fun testGetProfits() {
		assertNotThrow(client.getProfits(ProfitsParams(algo, userName, pageIndex = 0, pageSize = limit)))
	}
}