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
package com.binance4j.mining.client

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.mining.dto.OtherProfitsResponse
import com.binance4j.mining.param.*

/**
 * Api client for the NFT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints)
 */
class MiningClient
/**
 * @param key    API public key.
 * @param secret API secret key.
 */
	(key: String, secret: String) : RestClient<MiningMapping>(MiningMapping::class.java, key, secret) {
	/**
	 * Acquiring algorithms.
	 *
	 * @return The request to execute.
	 */
	fun getAlgorithms() = Request(service.getAlgorithms(AlgorithmsAcquisitionParams().toMap()))
	
	/**
	 * Acquiring coin name.
	 *
	 * @return The request to execute.
	 */
	fun getCoins() = Request(service.getCoins(CoinsAquisitionParams().toMap()))
	
	/**
	 * Request for detail miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getMinersDetails(params: MinerDetailsParams) = Request(service.getMinersDetails(params.toMap()))
	
	/**
	 * Request for miner list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getMiners(params: MinersParams) = Request(service.getMiners(params.toMap()))
	
	/**
	 * Get earnings list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getProfits(params: ProfitsParams) = Request(service.getProfits(params.toMap()))
	
	/**
	 * Get extra bonus list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOtherProfits(params: ProfitsParams): Request<OtherProfitsResponse> =
		Request(service.getOtherProfits(params.toMap()))
	
	/**
	 * Get mining account earning.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAccountProfits(params: AccountProfitsParams) = Request(service.getAccountProfits(params.toMap()))
	
	/**
	 * Get hash rate resale list.
	 *
	 * @return The request to execute.
	 */
	fun getHashrateResales() = Request(service.getHashrateResales(HashrateResaleListParams().toMap()))
	
	/**
	 * Get hash rate resale list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getHashrateResales(params: HashrateResaleListParams = HashrateResaleListParams()) =
		Request(service.getHashrateResales(params.toMap()))
	
	/**
	 * Get hash rate resale detail.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getHashrateResalesDetails(params: HashrateResaleDetailParam) =
		Request(service.getHashrateResalesDetails(params.toMap()))
	
	/**
	 * Hash rate resale request.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun resellHashrate(params: HashrateResaleParams) = Request(service.resellHashrate(params.toMap()))
	
	/**
	 * Cancel hash rate resale configuration.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelHashrateResaleConfiguration(params: HashrateResaleCancellationParams) =
		Request(service.cancelHashrateResaleConfiguration(params.toMap()))
	
	/**
	 * Get Statistic list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getStatistics(params: StatisticsParams) = Request(service.getStatistics(params.toMap()))
	
	/**
	 * Get Account list.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAccounts(params: AccountListParams) = Request(service.getAccounts(params.toMap()))
}