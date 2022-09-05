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

package com.binance4j.connectors.blvt.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient

/**
 * BLVT endpoints client.
 *
 * [Binance documentation](https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints)
 */
object BLVTClient : RestClient<BLVTMapping>(BLVTMapping::class.java) {
	/**
	 * Get BLVT Info.
	 *
	 * @param tokenName Token name.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getTokenInfo(tokenName: String? = null) = Request(service.getTokenInfo(tokenName))
	
	/**
	 * Get subscription record.
	 *
	 * @param tokenName  Token name.
	 * @param id         Subscription id.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param limit      Results limit.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getSubscriptions(tokenName: String? = null, id: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
		Request(service.getSubscriptions(tokenName , id , startTime , endTime , limit))
	
	/**
	 * Get redemption record.
	 *
	 * @param tokenName  Token name.
	 * @param id         Subscription id.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param limit      Results limit.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getRedemptions(tokenName: String? = null, id: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
		Request(service.getRedemptions(tokenName , id , startTime , endTime , limit))
	
	/**
	 * Get user limit info.
	 *
	 * @param tokenName Token name.
	 *
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getLimitInfo(tokenName: String? = null) = Request(service.getLimitInfo(tokenName))
	
	/**
	 * Subscribe BLVT.
	 *
	 * @param tokenName Token name.
	 * @param cost      Cost to subscribe to.
	 *
	 * @return The request to execute.
	 */
	fun subscribe(tokenName: String, cost: String) = Request(service.subscribe(tokenName,cost))
	
	
	/**
	 * Redeem BLVT.
	 *
	 * @param tokenName Token name.
	 * @param amount    Amount to redeem.
	 *
	 * @return The request to execute.
	 */
	fun redeem(tokenName: String, amount: String) = Request(service.redeem(tokenName, amount))
}