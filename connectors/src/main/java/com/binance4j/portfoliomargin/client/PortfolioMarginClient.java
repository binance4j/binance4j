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

package com.binance4j.portfoliomargin.client;

import com.binance4j.core.Request;
import com.binance4j.core.client.RestClient;
import com.binance4j.portfoliomargin.dto.AccountInfo;
import com.binance4j.portfoliomargin.dto.CollaterateRateInfo;
import com.binance4j.portfoliomargin.param.AccountInfoParams;
import com.binance4j.portfoliomargin.param.CollaterateRateInfoParams;

import java.util.List;

/**
 * Api client for the margin portfolio endpoints
 *
 * @see <a href=
 * "https://binance-docs.github.io/apidocs/spot/en/#portfolio-margin-endpoints">Documentation</a>
 */
public class PortfolioMarginClient extends RestClient<com.binance4j.portfoliomargin.client.PortfolioMarginMapping> {
    /**
     * @param key    API public key.
     * @param secret API secret key.
     */
    public PortfolioMarginClient(String key, String secret) {
        super(com.binance4j.portfoliomargin.client.PortfolioMarginMapping.class, key, secret);
    }

    /**
     * Get account infos.
     *
     * @return The request to execute.
     */
    public Request<AccountInfo> getAccountInfo() {
        return new Request<>(service.getAccountInfo(new AccountInfoParams().toMap()));
    }

    /**
     * Get collateral rate.
     *
     * @return The request to execute.
     */
    public Request<List<CollaterateRateInfo>> getCollateralRate() {
        return new Request<>(service.getCollateralRate(new CollaterateRateInfoParams().toMap()));
    }
}
