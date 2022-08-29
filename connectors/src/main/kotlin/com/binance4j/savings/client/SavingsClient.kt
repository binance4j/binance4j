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

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.savings.dto.*
import com.binance4j.savings.param.*

/**
 * Api client for the savings endpoints
 * @param key    API public key.
 * @param secret API secret key.
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/.savings-endpoints)
 */
class SavingsClient(key: String, secret: String) : RestClient<SavingsMapping>(SavingsMapping::class.java, key, secret) {
	/**
	 * Get flexible product list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getFlexibleProducts(params: FlexibleProductsParams = FlexibleProductsParams("")): Request<List<FlexibleProduct>> =
		Request(service.getFlexibleProducts(params.toMap()))
	
	/**
	 * Get left daily purchase quota of flexible product.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getLeftDailyFlexiblePurchaseQuota(params: PurchaseQuotaParams): Request<PurchaseQuota> =
		Request(service.getLeftDailyFlexiblePurchaseQuota(params.toMap()))
	
	/**
	 * Purchase Flexible Product.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun purchaseFlexible(params: FlexiblePurchaseParams): Request<PurchaseResponse> =
		Request(service.purchaseFlexible(params.toMap()))
	
	/**
	 * Get Left Daily Redemption Quota of Flexible Product.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getLeftDailyRedemptionQuota(params: RedemptionQuotaParams): Request<RedemptionQuota> =
		Request(service.getLeftDailyRedemptionQuota(params.toMap()))
	
	/**
	 * Redeem Flexible Product.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun redeemFlexible(params: RedemptionParams): Request<Void> = Request(service.redeemFlexible(params.toMap()))
	
	/**
	 * Get flexible product position.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getFlexibleProductPosition(params: FlexibleProductPositionParams = FlexibleProductPositionParams()): Request<List<FlexibleProductPosition>> =
		Request(service.getFlexibleProductPosition(params.toMap()))
	
	/**
	 * Get fixed and activity project list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getFixedProjects(params: FixedProjectListParams): Request<List<FixedProject>> =
		Request(service.getFixedProjects(params.toMap()))
	
	/**
	 * Purchase fixed project.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun purchaseFixed(params: FixedPurchaseParams): Request<PurchaseResponse> =
		Request(service.purchaseFixed(params.toMap()))
	
	/**
	 * Get fixed/activity project position.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getFixedProjectPosition(params: FixedProjectPositionParams): Request<List<FixedProjectPosition>> =
		Request(service.getFixedProjectPosition(params.toMap()))
	
	
	/**
	 * Get lending account.
	 *
	 * @return The request to execute.
	 */
	fun getAccount(): Request<LendingAccount> = Request(service.getAccount(LendingAccountParams().toMap()))
	
	/**
	 * Get purchase record.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getPurchases(params: LendingParams): Request<List<Purchase>> = Request(service.getPurchases(params.toMap()))
	
	/**
	 * Get redemption record.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getRedemptions(params: LendingParams): Request<List<Redemption>> =
		Request(service.getRedemptions(params.toMap()))
	
	/**
	 * Get interest record.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getInterests(params: LendingParams): Request<List<Interest>> = Request(service.getInterests(params.toMap()))
	
	/**
	 * Change fixed/activity position to daily position.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun fixedToDailyPosition(params: ChangePositionParams): Request<PositionChangedResponse> =
		Request(service.fixedToDailyPosition(params.toMap()))
}