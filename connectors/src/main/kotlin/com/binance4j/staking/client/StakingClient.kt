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

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.core.param.FramedPaging
import com.binance4j.core.param.Paging
import com.binance4j.core.param.Params.Companion.merge
import com.binance4j.staking.dto.*
import com.binance4j.staking.param.*
import java.util.Map

/**
 * Api client for the staking endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/.staking-endpoints)
 * @param key    API public key.
 * @param secret API secret key.
 */
class StakingClient(key: String, secret: String) : RestClient<StakingMapping>(StakingMapping::class.java, key, secret) {
    /**
     * Get available Staking product list.
     * @param params Request params.
     * @param paging Search pagination.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getProducts(params: ProductListParams, paging: Paging = Paging()): Request<List<Product>> {
        val replaceMap = Map.of("page", "current", "limit", "size")
        return Request(service.getProductList(merge(params.toMap(), paging.toMap(replaceMap))))
    }

    /**
     * Purchase Staking product.
     * @param params Request params.
     * @return The request to execute.
     */
    fun purchase(params: PurchaseParams): Request<PurchaseResponse> = Request(service.purchase(params.toMap()))

    /**
     * Redeem Staking product.
     * @param params Request params.
     * @return The request to execute.
     */
    fun redeem(params: RedeemParams): Request<RedeemResponse> = Request(service.redeem(params.toMap()))

    /**
     * Get Staking product position.
     * @param params Request params.
     * @param paging Paging.
     * @return The request to execute.
     */
    @JvmOverloads
    fun getPosition(params: PositionParams, paging: Paging = Paging()): Request<List<ProductPosition>> {
        val replaceMap = Map.of("page", "current", "limit", "size")
        return Request(service.getPosition(merge(params.toMap(), paging.toMap(replaceMap))))
    }

    /**
     * Get staking history.
     * @param params   Request params.
     * @param interval Search interval.
     * @return The request to execute.
     */
    fun getHistory(params: HistoryParams, interval: FramedPaging = FramedPaging()): Request<List<StakingRecord>> {
        val replaceMap = Map.of("page", "current", "limit", "size")
        return Request(service.getHistory(merge(params.toMap(), interval.toMap(replaceMap))))
    }

    /**
     * Set auto staking on Locked Staking or Locked DeFi Staking.
     * @param params Request params.
     * @return The request to execute.
     */
    fun setAutoStaking(params: AutoStakingParams): Request<AutoStakingResponse> = Request(service.setAutoStaking(params.toMap()))

    /**
     * Get personal left quota of Staking product.
     * @param params Request params.
     * @return The request to execute.
     */
    fun getLeftQuota(params: LeftQuotaParams): Request<LeftQuota> = Request(service.getLeftQuota(params.toMap()))
}