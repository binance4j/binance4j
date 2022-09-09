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
package com.binance4j.connectors.staking.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.staking.dto.ProductType
import com.binance4j.connectors.staking.dto.TransactionType

/**
 * Api client for the staking endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#staking-endpoints)
 */
object StakingClient : RestClient<StakingMapping>(StakingMapping::class.java) {
    /**
     * Get available Staking product list.
     *
     * @param product Product type.
     * @param asset   Product name.
     * @param current  Results page.
     * @param size Number of rows.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getProducts(product: ProductType, asset: String? = null, current: Int? = null, size: Int? = null) =
        Request(service.getProducts(product.toString(), asset, current, size))

    /**
     * Purchase Staking product.
     *
     * @param product   Product type.
     * @param productId Product id.
     * @param amount    Amount to purchase.
     * @param renewable Renew purchase? Active if product is `STAKING` or `L_DEFI`.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun purchase(product: ProductType, productId: String, amount: String, renewable: Boolean? = null) =
        Request(service.purchase(product.toString(), productId, amount, renewable))

    /**
     * Redeem Staking product.
     *
     * @param product    Product type.
     * @param productId  Product id.
     * @param positionId Position id. Mandatory if product is `STAKING` or `L_DEFI`.
     * @param amount     Amount to purchase. Mandatory if product is `F_DEFI`.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun redeem(product: ProductType, productId: String, positionId: String? = null, amount: String? = null) =
        Request(service.redeem(product.toString(), productId, positionId, amount))

    /**
     * Get Staking product position.
     *
     * @param product   Product type.
     * @param productId Product id.
     * @param asset     Product name.
     * @param current   Results page.
     * @param size      Number of rows.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getPosition(product: ProductType, productId: String? = null, asset: String? = null, current: Int? = null, size: Int? = null) =
        Request(service.getPosition(product.toString(), productId, asset, current, size))

    /**
     * Get staking history.
     *
     * @property product    Product type.
     * @property txnType    Transaction type.
     * @property asset      Product name.
     * @property startTime     Start time in ms.
     * @property endTime       End time in ms.
     * @property current       Result page.
     * @property size          Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getHistory(
        product: ProductType,
        txnType: TransactionType,
        asset: String? = null,
        startTime: Long? = null,
        endTime: Long? = null,
        current: Int? = null,
        size: Int? = null
    ) = Request(service.getHistory(product.toString(), txnType.toString(), asset, startTime, endTime, current, size))

    /**
     * Set auto staking on Locked Staking or Locked DeFi Staking.
     *
     * @param product    Product type.
     * @param positionId Position id.
     * @param renewable  Renew purchase?
     *
     * @return The request to execute.
     */
    fun setAutoStaking(product: ProductType, positionId: String, renewable: Boolean) = Request(service.setAutoStaking(product, positionId, renewable))

    /**
     * Get personal left quota of Staking product.
     *
     * @param product   Product type.
     * @param productId Product id.
     *
     * @return The request to execute.
     */
    fun getLeftQuota(product: ProductType, productId: String) = Request(service.getLeftQuota(product.toString(), productId))
}