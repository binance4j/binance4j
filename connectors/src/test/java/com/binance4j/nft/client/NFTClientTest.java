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

import com.binance4j.core.Binance4j;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.param.FramedPaging;
import com.binance4j.core.param.Paging;
import com.binance4j.core.test.CustomTest;
import com.binance4j.nft.dto.OrderType;
import com.binance4j.nft.param.TransactionHistoryParams;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.junit.jupiter.api.Test;

public class NFTClientTest extends CustomTest {
    int page = 1;
    com.binance4j.nft.client.NFTClient client = new com.binance4j.nft.client.NFTClient(key, secret);

    public NFTClientTest() {
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Binance4j.MAPPER.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
    }

    @Test
    void testGetAssets() throws ApiException {
        testNotThrow(client.getAssets());
    }

    @Test
    void testGetAssets2() throws ApiException {
        testNotThrow(client.getAssets(new Paging(1)));
    }

    @Test
    void testGetDeposits() throws ApiException {
        testNotThrow(client.getDeposits());
    }

    @Test
    void testGetDeposits2() throws ApiException {
        testNotThrow(client.getDeposits(new FramedPaging(page)));
    }

    @Test
    void testGetTransactions() throws ApiException {
        for (var o : OrderType.values()) {
            testNotThrow(client.getTransactions(new TransactionHistoryParams(o)));
        }
    }

    @Test
    void testGetTransactions2() throws ApiException {
        testNotThrow(
                client.getTransactions(new TransactionHistoryParams(OrderType.SELL_ORDER),
                        new FramedPaging(page)));
    }

    @Test
    void testGetWithdraws() throws ApiException {
        testNotThrow(client.getWithdraws());
    }

    @Test
    void testGetWithdraws2() throws ApiException {
        testNotThrow(client.getWithdraws(new FramedPaging(1)));
    }
}
