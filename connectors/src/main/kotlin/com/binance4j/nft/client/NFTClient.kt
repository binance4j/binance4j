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
package com.binance4j.nft.client

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.nft.param.AssetParams
import com.binance4j.nft.param.OperationParams
import com.binance4j.nft.param.TransactionHistoryParams

/**
 * Api client for the NFT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints)
 */
object NFTClient : RestClient<NFTMapping>(NFTMapping::class.java) {
	/**
	 * Get NFT Transaction History.
	 *
	 * @param params    Request params.
	 * @return The request to execute.
	 */
	fun getTransactions(params: TransactionHistoryParams) = Request(service.getTransactions(params.toMap()))
	
	/**
	 * Get NFT deposit History.
	 *
	 * @param params Request params
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getDeposits(params: OperationParams = OperationParams()) = Request(service.getDeposits(params.toMap()))
	
	/**
	 * Get NFT withdraw History.
	 *
	 * @param params Request params
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getWithdraws(params: OperationParams = OperationParams()) = Request(service.getWithdraws(params.toMap()))
	
	/**
	 * Get NFT assets.
	 *
	 * @param params Paging.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getAssets(params: AssetParams = AssetParams()) = Request(service.getAssets(params.toMap()))
}