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

package com.binance4j.pay.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.core.param.Params;
import com.binance4j.core.param.TimeFrame;
import com.binance4j.pay.dto.TradeHistory;
import com.binance4j.pay.param.TradeHistoryParams;

/**
 * Api client for the pay endpoints
 *
 * @see <a href=
 * "https://binance-docs.github.io/apidocs/spot/en/#pay-endpoints">Documentation</a>
 */
public class PayClient extends RestClient<com.binance4j.pay.client.PayMapping> {
    /**
     * @param key    API public key.
     * @param secret API secret key.
     */
    public PayClient(String key, String secret) {
        super(com.binance4j.pay.client.PayMapping.class, key, secret);
    }

    /**
     * Get pay trades.
     *
     * @return The request to execute.
     */
    public Request<TradeHistory> getTrades() {
        return new Request<>(service.getTrades(new TradeHistoryParams().toMap()));
    }

    /**
     * Get pay trades.
     *
     * @param timeFrame Time frame.
     * @return The request to execute.
     */
    public Request<TradeHistory> getTrades(TimeFrame timeFrame) {
        return new Request<>(service.getTrades(Params.merge(new TradeHistoryParams(), timeFrame)));
    }
}
