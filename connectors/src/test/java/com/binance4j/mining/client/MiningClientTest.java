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

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.core.test.CustomTest;
import com.binance4j.mining.param.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MiningClientTest extends CustomTest {
    String algo = "sha256";
    int configId = 123;
    String userName = "vivienld";
    String workerName = "vivienld.001";
    String toPoolUser = "toPoolUser";
    FramedPaging framedPaging = new FramedPaging(1);
    TimeFrame timeFrame = new TimeFrame(limit);
    Long endDate = System.currentTimeMillis();
    Long startDate = System.currentTimeMillis() - 365L * 24 * 60 * 60 * 1000;
    Long hashRate = 0L;
    MiningClient client = new MiningClient(key, secret);
    Paging paging = new Paging(1, limit);

    public MiningClientTest() {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetAccounts() throws ApiException {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        testHasNulls(client.getAccounts(new AccountListParams(algo, userName)), List.of("list", "userName"), true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetAlgorithms() throws ApiException {
        testNotThrow(client.getAlgorithms());
    }

    @Test
    void testGetCoins() throws ApiException {
        testNotThrow(client.getCoins());
    }

    @Test
    void testGetStatistics() throws ApiException {
        testNotThrow(client.getStatistics(new StatisticsParams(algo, userName)));
    }

    // NOT TESTED SINCE I DON'T MINE

    // TODO @Test
    void testResellHashrate() throws ApiException {
        testNotThrow(client
                .resellHashrate(new HashrateResaleParams(userName, algo, endDate, startDate, toPoolUser, hashRate)));
    }

    // TODO @Test
    void testCancelHashrateResaleConfiguration() throws ApiException {
        testNotThrow(
                client
                        .cancelHashrateResaleConfiguration(new HashrateResaleCancellationParams(configId, userName)));
    }

    // TODO @Test
    void testGetAccountProfits() throws ApiException {
        testNotThrow(client.getAccountProfits(new AccountProfitsParams(algo, userName)));
    }

    // TODO @Test
    void testGetAccountProfitsFramed() throws ApiException {
        testNotThrow(client.getAccountProfits(new AccountProfitsParams(algo, userName), framedPaging));
    }

    // TODO @Test
    void testGetHashrateResales() throws ApiException {
        testNotThrow(client.getHashrateResales());
    }

    // TODO @Test
    void testGetHashrateResales2() throws ApiException {
        testNotThrow(client.getHashrateResales(paging));
    }

    // TODO @Test
    void testGetHashrateResalesDetails() throws ApiException {
        testNotThrow(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName)));
    }

    // TODO @Test
    void testGetHashrateResalesDetails2() throws ApiException {
        testNotThrow(client.getHashrateResalesDetails(new HashrateResaleDetailParam(configId, userName), paging));
    }

    // TODO @Test
    void testGetMiners() throws ApiException {
        testNotThrow(client.getMiners(new MinersParams(algo, userName)));
    }

    // TODO @Test
    void testGetMinersDetails() throws ApiException {
        testNotThrow(client.getMinersDetails(new MinerDetailsParams(algo, userName, workerName)));
    }

    // TODO @Test
    void testGetOtherProfits() throws ApiException {
        testNotThrow(client.getOtherProfits(new ProfitsParams(algo, userName), framedPaging));
    }

    // TODO @Test
    void testGetProfits() throws ApiException {
        testNotThrow(client.getProfits(new ProfitsParams(algo, userName), framedPaging));
    }

}
