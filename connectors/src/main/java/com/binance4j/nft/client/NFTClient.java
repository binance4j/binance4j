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

package com.binance4j.nft.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.nft.dto.AssetHistory;
import com.binance4j.nft.dto.DepositHistory;
import com.binance4j.nft.dto.TransactionHistory;
import com.binance4j.nft.dto.WithdrawHistory;
import com.binance4j.nft.param.AssetParams;
import com.binance4j.nft.param.OperationParams;
import com.binance4j.nft.param.TransactionHistoryParams;

/**
 * Api client for the NFT endpoints
 *
 * @see <a href=
 * "https://binance-docs.github.io/apidocs/spot/en/#nft-endpoints">Documentation</a>
 */
public class NFTClient extends RestClient<com.binance4j.nft.client.NFTMapping> {
    /**
     * @param key    API public key.
     * @param secret API secret key.
     */
    public NFTClient(String key, String secret) {
        super(com.binance4j.nft.client.NFTMapping.class, key, secret);
    }

    /**
     * Get NFT Transaction History.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<TransactionHistory> getTransactions(TransactionHistoryParams params) {
        return new Request<>(service.getTransactions(params.toMap()));
    }

    /**
     * Get NFT Transaction History.
     *
     * @param params       Request params.
     * @param framedPaging Paging.
     * @return The request to execute.
     */
    public Request<TransactionHistory> getTransactions(TransactionHistoryParams params, FramedPaging framedPaging) {
        return new Request<>(service.getTransactions(Params.merge(params, framedPaging)));
    }

    /**
     * Get NFT deposit History.
     *
     * @param interval Time interval search.
     * @return The request to execute.
     */
    public Request<DepositHistory> getDeposits(FramedPaging interval) {
        return new Request<>(service.getDeposits(Params.merge(new OperationParams(), interval)));
    }

    /**
     * Get NFT deposit History.
     *
     * @return The request to execute.
     */
    public Request<DepositHistory> getDeposits() {
        return new Request<>(service.getDeposits(new OperationParams().toMap()));
    }

    /**
     * Get NFT withdraw History.
     *
     * @param interval Time interval search.
     * @return The request to execute.
     */
    public Request<WithdrawHistory> getWithdraws(FramedPaging interval) {
        return new Request<>(service.getWithdraws(Params.merge(new OperationParams(), interval)));
    }

    /**
     * Get NFT withdraw History.
     *
     * @return The request to execute.
     */
    public Request<WithdrawHistory> getWithdraws() {
        return new Request<>(service.getWithdraws(new OperationParams().toMap()));
    }

    /**
     * Get NFT assets.
     *
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<AssetHistory> getAssets(Paging paging) {
        return new Request<>(service.getAssets(Params.merge(new AssetParams().toMap(), paging.toMap())));
    }

    /**
     * Get NFT assets.
     *
     * @return The request to execute.
     */
    public Request<AssetHistory> getAssets() {
        return new Request<>(service.getAssets(new AssetParams().toMap()));
    }
}
