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
import com.binance4j.core.param.FramedPaging
import com.binance4j.core.param.Paging
import com.binance4j.core.param.Params.Companion.merge
import com.binance4j.nft.dto.AssetHistory
import com.binance4j.nft.dto.TransactionHistory
import com.binance4j.nft.dto.WithdrawHistory
import com.binance4j.nft.param.AssetParams
import com.binance4j.nft.param.OperationParams
import com.binance4j.nft.param.TransactionHistoryParams

/**
 * Api client for the NFT endpoints
 *
 * @see [Documentation](https://binance-docs.github.io/apidocs/spot/en/.nft-endpoints)
 */
class NFTClient
/**
 * @param key    API public key.
 * @param secret API secret key.
 */
(key: String, secret: String) : RestClient<NFTMapping>(NFTMapping::class.java, key, secret) {
	/**
	 * Get NFT Transaction History.
	 *
	 * @param params       Request params.
	 * @param framedPaging Paging.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getTransactions(params: TransactionHistoryParams, framedPaging: FramedPaging = FramedPaging()): Request<TransactionHistory> = Request(service.getTransactions(merge(params, framedPaging)))
	
	/**
	 * Get NFT deposit History.
	 *
	 * @param interval Time interval search.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getDeposits(interval: FramedPaging = FramedPaging()): Request<com.binance4j.wallet.dto.DepositHistory> = Request(service.getDeposits(merge(OperationParams(), interval)))
	
	/**
	 * Get NFT withdraw History.
	 *
	 * @param interval Time interval search.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getWithdraws(interval: FramedPaging = FramedPaging()): Request<WithdrawHistory> = Request(service.getWithdraws(merge(OperationParams(), interval)))
	
	/**
	 * Get NFT assets.
	 *
	 * @param paging Paging.
	 * @return The request to execute.
	 */
	@JvmOverloads
	fun getAssets(paging: Paging = Paging()): Request<AssetHistory> = Request(service.getAssets(merge(AssetParams(), paging)))
}