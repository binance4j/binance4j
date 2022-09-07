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
package com.binance4j.connectors.nft.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.nft.dto.OrderType

/**
 * Api client for the NFT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints)
 */
object NFTClient : RestClient<NFTMapping>(NFTMapping::class.java) {
    /**
     * Get NFT Transaction History.
     *
     * @param orderType Order type.
     * @param startTime Start time.
     * @param endTime End time.
     * @param page Result page.
     * @param limit Result limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTransactions(orderType: OrderType, startTime: Long? = null, endTime: Long? = null, page: Int? = null, limit: Int? = null) =
        Request(service.getTransactions(orderType.toString(), startTime, endTime, page, limit))

    /**
     * Get NFT deposit History.
     *
     * @param startTime Start time.
     * @param endTime End time.
     * @param page Result page.
     * @param limit Result limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getDeposits(startTime: Long? = null, endTime: Long? = null, page: Int? = null, limit: Int? = null) =
        Request(service.getDeposits(startTime, endTime, page, limit))

    /**
     * Get NFT withdraw History.
     *
     * @param startTime Start time.
     * @param endTime End time.
     * @param page Result page.
     * @param limit Result limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getWithdraws(startTime: Long? = null, endTime: Long? = null, page: Int? = null, limit: Int? = null) =
        Request(service.getWithdraw(startTime, endTime, page, limit))

    /**
     * Get NFT assets.
     *
     * @param page Result page.
     * @param limit Result limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAssets(page: Int? = null, limit: Int? = null) = Request(service.getAssets(page, limit))
}