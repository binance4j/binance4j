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
package com.binance4j.connectors.savings.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.savings.dto.*

/**
 * Api client for the savings endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#savings-endpoints)
 */
object SavingsClient : RestClient<SavingsMapping>(SavingsMapping::class.java) {
    /**
     * Get flexible product list.
     *
     * @param status    Product status.
     * @param featured  Featured.
     * @param current   Current page.
     * @param size      Page size.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFlexibleProducts(status: FlexibleProductStatus? = FlexibleProductStatus.ALL, featured: Featured? = null, current: Int? = null, size: Int? = null) =
        Request(service.getFlexibleProducts(status.toString(), featured, current, size))

    /**
     * Get left daily purchase quota of flexible product.
     *
     * @param productId Product id.
     *
     * @return The request to execute.
     */
    fun getLeftDailyFlexiblePurchaseQuota(productId: String) = Request(service.getLeftDailyFlexiblePurchaseQuota(productId))

    /**
     * Purchase Flexible Product.
     *
     * @param productId Product id.
     * @param amount    Amount.
     *
     * @return The request to execute.
     */
    fun purchaseFlexible(productId: String, amount: String) = Request(service.purchaseFlexible(productId, amount))

    /**
     * Get Left Daily Redemption Quota of Flexible Product.
     *
     * @param productId Product id.
     * @param type      Product type.
     *
     * @return The request to execute.
     */
    fun getLeftDailyRedemptionQuota(productId: String, type: ProductType) = Request(service.getLeftDailyRedemptionQuota(productId, type.toString()))

    /**
     * Redeem Flexible Product.
     *
     * @param productId Product id.
     * @param amount    Amount.
     * @param type      Product type.
     *
     * @return The request to execute.
     */
    fun redeemFlexible(productId: String, amount: String, type: ProductType) = Request(service.redeemFlexible(productId, amount, type.toString()))

    /**
     * Get flexible product position.
     *
     * @param asset Asset.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFlexibleProductPosition(asset: String? = null) = Request(service.getFlexibleProductPosition(asset))

    /**
     * Get fixed and activity project list.
     *
     * @param type   Project type.
     * @param status Project status. default: `START_TIME`.
     * @param sortBy Sorting.
     * @param asset  Asset.
     * @param page  Results page.
     * @param limit Number of rows.
     * @param isSortAsc Ascending sorting.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFixedProjects(
        type: FixedProjectType,
        status: FixedProjectStatus,
        sortBy: FixedProjectSorting,
        asset: String? = null,
        page: Int? = null,
        limit: Int? = null,
        isSortAsc: Boolean? = null
    ) = Request(service.getFixedProjects(type.toString(), status.toString(), sortBy.toString(), asset, page, limit, isSortAsc))

    /**
     * Purchase fixed project.
     *
     * @param productId Product id.
     * @param lot       Amount.
     *
     * @return The request to execute.
     */
    fun purchaseFixed(productId: String, lot: Long) = Request(service.purchaseFixed(productId, lot))

    /**
     * Get fixed/activity project position.
     *
     * @param asset     Asset.
     * @param projectId Project id.
     * @param status    Status.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFixedProjectPosition(asset: String? = null, projectId: String? = null, status: FixedProjectPositionStatus? = null) =
        Request(service.getFixedProjectPosition(asset, projectId, status.toString()))

    /**
     * Get lending account.
     *
     * @return The request to execute.
     */
    fun getAccount() = Request(service.getAccount())

    /**
     * Get purchase record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getPurchases(lendingType: LendingType, asset: String? = null, startTime: Long? = null, endTime: Long? = null, current: Int? = null, size: Int? = null) =
        Request(service.getPurchases(lendingType.toString(), asset, startTime, endTime, current, size))

    /**
     * Get redemption record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getRedemptions(
        lendingType: LendingType, asset: String? = null, startTime: Long? = null, endTime: Long? = null, current: Int? = null, size: Int? = null
    ) = Request(service.getRedemptions(lendingType.toString(), asset, startTime, endTime, current, size))

    /**
     * Get interest record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getInterests(
        lendingType: LendingType, asset: String? = null, startTime: Long? = null, endTime: Long? = null, current: Int? = null, size: Int? = null
    ) = Request(service.getInterests(lendingType.toString(), asset, startTime, endTime, current, size))

    /**
     * Change fixed/activity position to daily position.
     *
     * @param projectId  Project id.
     * @param lot        Lot size.
     * @param positionId Position id for fixed position.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun fixedToDailyPosition(projectId: String, lot: Long, positionId: Long? = null) = Request(service.fixedToDailyPosition(projectId, lot, positionId))
}