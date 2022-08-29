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

package com.binance4j.mining.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.Params;
import com.binance4j.mining.dto.*;
import com.binance4j.mining.param.*;

import java.util.Map;

/**
 * Api client for the NFT endpoints
 *
 * @see <a href=
 * "https://binance-docs.github.io/apidocs/spot/en/#mining-endpoints">Documentation</a>
 */
public class MiningClient extends RestClient<MiningMapping> {
    /**
     * @param key    API public key.
     * @param secret API secret key.
     */
    public MiningClient(String key, String secret) {
        super(MiningMapping.class, key, secret);
    }

    /**
     * Acquiring algorithms.
     *
     * @return The request to execute.
     */
    public Request<AlgorithmsResponse> getAlgorithms() {
        return new Request<>(service.getAlgorithms(new AlgorithmsAquisitionParams().toMap()));
    }

    /**
     * Acquiring coin name.
     *
     * @return The request to execute.
     */
    public Request<CoinsResponse> getCoins() {
        return new Request<>(service.getCoins(new CoinsAquisitionParams().toMap()));
    }

    /**
     * Request for detail miner list.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<MinerDetailsResponse> getMinersDetails(MinerDetailsParams params) {
        return new Request<>(service.getMinersDetails(params.toMap()));
    }

    /**
     * Request for miner list.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<WorkersResponse> getMiners(MinersParams params) {
        return new Request<>(service.getMiners(params.toMap()));
    }

    /**
     * Get earnings list.
     *
     * @param params Request params.
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<ProfitResponse> getProfits(ProfitsParams params, FramedPaging paging) {
        var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
        return new Request<>(service.getProfits(Params.merge(params.toMap(), paging.toMap(replace))));
    }

    /**
     * Get extra bonus list.
     *
     * @param params Request params.
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<OtherProfitsResponse> getOtherProfits(ProfitsParams params, FramedPaging paging) {
        var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
        return new Request<>(service.getOtherProfits(Params.merge(params.toMap(), paging.toMap(replace))));
    }

    /**
     * Get mining account earning.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<AccountProfitsResponse> getAccountProfits(AccountProfitsParams params) {
        return new Request<>(service.getAccountProfits(params.toMap()));
    }

    /**
     * Get mining account earning.
     *
     * @param params Request params.
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<AccountProfitsResponse> getAccountProfits(AccountProfitsParams params, FramedPaging paging) {
        var replace = Map.of("startTime", "startDate", "endTime", "endDate", "page", "pageIndex", "limit", "pageSize");
        return new Request<>(service.getAccountProfits(Params.merge(params.toMap(), paging.toMap(replace))));
    }

    /**
     * Get hashrate resale list.
     *
     * @return The request to execute.
     */
    public Request<HashrateResaleListResponse> getHashrateResales() {
        return new Request<>(service.getHashrateResales(new HashrateResaleListParams().toMap()));
    }

    /**
     * Get hashrate resale list.
     *
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<HashrateResaleListResponse> getHashrateResales(Paging paging) {
        var replace = Map.of("page", "pageIndex", "limit", "pageSize");
        return new Request<>(service
                .getHashrateResales(Params.merge(new HashrateResaleListParams().toMap(), paging.toMap(replace))));
    }

    /**
     * Get hashrate resale detail.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<HashrateResaleDetailResponse> getHashrateResalesDetails(HashrateResaleDetailParam params) {
        return new Request<>(service.getHashrateResalesDetails(params.toMap()));
    }

    /**
     * Get hashrate resale detail.
     *
     * @param params Request params.
     * @param paging Paging.
     * @return The request to execute.
     */
    public Request<HashrateResaleDetailResponse> getHashrateResalesDetails(HashrateResaleDetailParam params,
                                                                           Paging paging) {
        var replace = Map.of("page", "pageIndex", "limit", "pageSize");
        return new Request<>(service.getHashrateResalesDetails(Params.merge(params.toMap(), paging.toMap(replace))));
    }

    /**
     * Hashrate resale request.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<HashrateResaleResponse> resellHashrate(HashrateResaleParams params) {
        return new Request<>(service.resellHashrate(params.toMap()));
    }

    /**
     * Cancel hashrate resale configuration.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<HashrateResaleCancellationResponse> cancelHashrateResaleConfiguration(
            HashrateResaleCancellationParams params) {
        return new Request<>(service.cancelHashrateResaleConfiguration(params.toMap()));
    }

    /**
     * Get Statistic list.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<StatisticsResponse> getStatistics(StatisticsParams params) {
        return new Request<>(service.getStatistics(params.toMap()));
    }

    /**
     * Get Account list.
     *
     * @param params Request params.
     * @return The request to execute.
     */
    public Request<AccountListResponse> getAccounts(AccountListParams params) {
        return new Request<>(service.getAccounts(params.toMap()));
    }
}
