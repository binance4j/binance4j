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
import com.binance4j.core.Request
import com.binance4j.core.client.RestClient

/**
 * Api client for the BLVT endpoints.
 *
 * @param key    API public key.
 * @param secret API secret key.
 *
 * [Binance documentation](https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints)
 */
class BLVTClient(key: String, secret: String) : RestClient<BLVTMapping>(BLVTMapping::class.java, key, secret) {
	/**
	 * Get BLVT Info.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getTokenInfo(params: TokenInfoParams = TokenInfoParams()) = Request(service.getTokenInfo(params.toMap()))
	
	/**
	 * Get subscription record.
	 *
	 * @param params    Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getSubscriptions(params: TransactionRecordParams = TransactionRecordParams()) =
		Request(service.getSubscriptions(params.toMap()))
	
	/**
	 * Get redemption record.
	 *
	 * @param params    Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getRedemptions(params: TransactionRecordParams = TransactionRecordParams()) =
		Request(service.getRedemptions(params.toMap()))
	
	/**
	 * Get user limit info.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getLimitInfo(params: LimitInfoParams = LimitInfoParams()) = Request(service.getLimitInfo(params.toMap()))
	
	/**
	 * Subscribe BLVT.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun subscribe(params: SubscriptionParams) = Request(service.subscribe(params.toMap()))
	
	
	/**
	 * Redeem BLVT.
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun redeem(params: RedemptionParams) = Request(service.redeem(params.toMap()))
}