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

import com.binance4j.blvt.dto.*
import com.binance4j.blvt.param.*
import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.core.param.Params
import com.binance4j.core.param.TimeFrame


/**
 * Api client for the BLVT endpoints.
 * @param key    API public key.
 * @param secret API secret key.
 *
 * [Binance doc](https://binance-docs.github.io/apidocs/spot/en/#blvt-endpoints)
 */
class BLVTClient(key: String, secret: String) : RestClient<BLVTMapping>(BLVTMapping::class.java, key, secret) {
    /**
     * Get BLVT Info.
     * @param params Request params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTokenInfo(params: TokenInfoParams? = TokenInfoParams()): Request<List<Token>> = Request(service.getTokenInfo(Params.merge(params)))

    /**
     * Get subscription record.
     * @param params    Request params.
     * @param timeFrame Time search params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getSubscriptions(params: TransactionRecordParams? = TransactionRecordParams(), timeFrame: TimeFrame? = null): Request<List<Subscription>> =
        Request(service.getSubscriptions(Params.merge(params, timeFrame)))

    /**
     * Get redemption record.
     * @param params    Request params.
     * @param timeFrame Time search params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getRedemptions(params: TransactionRecordParams? = TransactionRecordParams(), timeFrame: TimeFrame? = null): Request<List<Redemption>> =
        Request(service.getRedemptions(Params.merge(params, timeFrame)))

    /**
     * Get user limit info.
     * @param params Request params.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getLimitInfo(params: LimitInfoParams? = LimitInfoParams()): Request<List<LimitInfo>> = Request(service.getLimitInfo(Params.merge(params)))


    /**
     * Subscribe BLVT.
     * @param params Request params.
     * @return The request to execute.
     */
    fun subscribe(params: SubscriptionParams): Request<SubscriptionResponse> = Request(service.subscribe(params.toMap()))


    /**
     * Redeem BLVT.
     * @param params Request params.
     * @return The request to execute.
     */
    fun redeem(params: RedemptionParams): Request<RedemptionResponse> = Request(service.redeem(params.toMap()))
}
