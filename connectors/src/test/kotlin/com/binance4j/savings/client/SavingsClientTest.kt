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
package com.binance4j.savings.client

import com.binance4j.connectors.Connectors
import com.binance4j.core.Binance4j
import com.binance4j.core.test.CustomTest
import com.binance4j.savings.dto.FixedProjectType
import com.binance4j.savings.dto.LendingType
import com.binance4j.savings.dto.ProductType
import com.binance4j.savings.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class SavingsClientTest : CustomTest() {
	val client: SavingsClient
		get() = Connectors.rest(key, secret).savings()
	
	@Test
	fun testGetAccount() {
		assertNotThrow(client.getAccount())
	}
	
	@Test
	fun testGetFixedProjects() {
		assertNotThrow(client.getFixedProjects(FixedProjectListParams(FixedProjectType.CUSTOMIZED_FIXED)))
		assertNotThrow(client.getFixedProjects(FixedProjectListParams(FixedProjectType.ACTIVITY)))
	}
	
	@Test
	fun testGetFlexibleProducts() {
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getFlexibleProducts())
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	fun testGetInterests() {
		assertNotThrow(client.getInterests(LendingParams(LendingType.DAILY)))
		assertNotThrow(client.getInterests(LendingParams(LendingType.ACTIVITY)))
		assertNotThrow(client.getInterests(LendingParams(LendingType.CUSTOMIZED_FIXED)))
	}
	
	@Test
	fun testGetPurchases() {
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getPurchases(LendingParams(LendingType.DAILY)))
		assertNotThrow(client.getPurchases(LendingParams(LendingType.ACTIVITY)))
		assertNotThrow(client.getPurchases(LendingParams(LendingType.CUSTOMIZED_FIXED)))
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	fun testGetRedemptions() {
		assertNotThrow(client.getRedemptions(LendingParams(LendingType.DAILY)))
		assertNotThrow(client.getRedemptions(LendingParams(LendingType.ACTIVITY)))
		assertNotThrow(client.getRedemptions(LendingParams(LendingType.CUSTOMIZED_FIXED)))
	}
	
	@Test
	fun testGetLeftDailyFlexiblePurchaseQuota() {
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		val productId = client.getFlexibleProducts().sync()[0].productId
		assertNotThrow(client.getLeftDailyFlexiblePurchaseQuota(PurchaseQuotaParams(productId)))
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	fun testGetLeftDailyRedemptionQuota() {
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		val productId = client.getFlexibleProducts().sync()[0].productId
		assertNotThrow(client.getLeftDailyRedemptionQuota(RedemptionQuotaParams(productId, ProductType.FAST)))
		Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	// NOT TESTED
	// TODO @Test
	fun testFixedToDailyPosition() {
		assertNotThrow(client.fixedToDailyPosition(ChangePositionParams("projectId", 0L)))
	}
	
	// TODO @Test
	fun testGetFixedProjectPosition() {
		assertNotThrow(client.getFixedProjectPosition(FixedProjectPositionParams(null, null, null)))
	}
	
	// TODO @Test
	fun testGetFlexibleProductPosition() {
		assertNotThrow(client.getFlexibleProductPosition())
	}
	
	// TODO @Test
	fun testPurchaseFixed() {
		assertNotThrow(client.purchaseFixed(FixedPurchaseParams("productId", 1L)))
	}
	
	// TODO @Test
	fun testPurchaseFlexible() {
		assertNotThrow(client.purchaseFlexible(FlexiblePurchaseParams("productId", "amount")))
	}
	
	// TODO @Test
	fun testRedeemFlexible() {
		assertNotThrow(client.redeemFlexible(RedemptionParams("productId", "amount", ProductType.FAST)))
	}
}