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
package com.binance4j.connectors.mining.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient

/**
 * Api client for the NFT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints)
 */
object MiningClient : RestClient<MiningMapping>(MiningMapping::class.java) {
    /**
     * Acquiring algorithms.
     *
     * @return The request to execute.
     */
    fun getAlgorithms() = Request(service.getAlgorithms())

    /**
     * Acquiring coin name.
     *
     * @return The request to execute.
     */
    fun getCoins() = Request(service.getCoins())

    /**
     * Request for detail miner list.
     *
     * @param algo       Algorithm.
     * @param userName   Mining account.
     * @param workerName Miner’s name.
     *
     * @return The request to execute.
     */
    fun getMinersDetails(algo: String, userName: String, workerName: String) = Request(service.getMinersDetails(algo, userName, workerName))

    /**
     * Request for miner list.
     *
     * @param algo         Algorithm.
     * @param userName     Mining account.
     * @param pageIndex    Page number.
     * @param sort         Sort sequence.
     * @param sortColumn   Miner sort.
     * @param workerStatus Miner status.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getMiners(algo: String, userName: String, workerStatus: String? = null, pageIndex: Int? = null, sort: String? = null, sortColumn: String? = null) =
        Request(service.getMiners(algo, userName, workerStatus, pageIndex, sort, sortColumn))

    /**
     * Get earnings list.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account test.
     * @param coin      Coin name.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getProfits(
        algo: String, userName: String, coin: String? = null,
        startDate: Long? = null, endDate: Long? = null, pageIndex: Int? = null, pageSize: Int? = null
    ) = Request(service.getProfits(algo, userName, coin, startDate, endDate, pageIndex, pageSize))

    /**
     * Get extra bonus list.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account test.
     * @param coin      Coin name.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getOtherProfits(
        algo: String, userName: String, coin: String? = null,
        startDate: Long? = null, endDate: Long? = null, pageIndex: Int? = null, pageSize: Int? = null
    ) = Request(service.getOtherProfits(algo, userName, coin, startDate, endDate, pageIndex, pageSize))

    /**
     * Get mining account earning.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAccountProfits(
        algo: String, userName: String, startDate: Long? = null, endDate: Long? = null, pageIndex: Int? = null, pageSize: Int? = null
    ) = Request(service.getAccountProfits(algo, userName, startDate, endDate, pageIndex, pageSize))

    /**
     * Get hash rate resale list.
     *
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getHashrateResales(pageIndex: Int? = null, pageSize: Int? = null) = Request(service.getHashrateResales(pageIndex, pageSize))

    /**
     * Get hash rate resale detail.
     *
     * @param configId    Config id.
     * @param userName    User name.
     * @param pageIndex   Result page.
     * @param pageSize    Results in the page.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getHashrateResalesDetails(configId: Int, userName: String, pageIndex: Int? = null, pageSize: Int? = null) =
        Request(service.getHashrateResalesDetails(configId, userName, pageIndex, pageSize))

    /**
     * Hash rate resale request.
     *
     * @param userName   Mining Account test.
     * @param algo       Transfer algorithm.
     * @param endDate    Resale End Time in ms.
     * @param startDate  Resale Start Time in ms.
     * @param toPoolUser Mining Account.
     * @param hashRate   Resale hash rate h/s must be transferred (BTC is greater than 500000000000 ETH is greater than 500000).
     *
     * @return The request to execute.
     */
    fun resellHashrate(userName: String, algo: String, startDate: Long, endDate: Long, toPoolUser: String, hashRate: Long) =
        Request(service.resellHashrate(userName, algo, startDate, endDate, toPoolUser, hashRate))

    /**
     * Cancel hash rate resale configuration.
     *
     * @param configId Config id.
     * @param userName User name.
     *
     * @return The request to execute.
     */
    fun cancelHashrateResaleConfiguration(configId: Int, userName: String) =
        Request(service.cancelHashrateResaleConfiguration(configId, userName))

    /**
     * Get Statistic list.
     *
     * @param algo     Algorithm.
     * @param userName Mining account.
     *
     * @return The request to execute.
     */
    fun getStatistics(algo: String, userName: String) = Request(service.getStatistics(algo, userName))

    /**
     * Get Account list.
     *
     * @param algo     Algorithm.
     * @param userName Mining account.
     *
     * @return The request to execute.
     */
    fun getAccounts(algo: String, userName: String) = Request(service.getAccounts(algo, userName))
}