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
package com.binance4j.connectors.portfoliomargin.client

import com.binance4j.connectors.core.Headers.API_H
import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.UID_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.portfoliomargin.dto.AccountInfo
import com.binance4j.connectors.portfoliomargin.dto.BankruptcyLoanAmount
import com.binance4j.connectors.portfoliomargin.dto.CollateralRateInfo
import com.binance4j.connectors.portfoliomargin.dto.RepayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * [PortfolioMarginClient] mapping.
 */
interface PortfolioMarginMapping {
    /**
     * Get account info.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/portfolio/account")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getAccountInfo(): Call<AccountInfo>

    /**
     * Get collateral rate.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/portfolio/collateralRate")
    @Headers(API_H, IP_H, "X-WEIGHT: 50")
    fun getCollateralRate(): Call<List<CollateralRateInfo>>

    /**
     * Get portfolio margin bankruptcy loan amount
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/portfolio/pmLoan")
    @Headers(SIGNED_H, UID_H, "X-WEIGHT: 500")
    fun getBankruptcyLoanAmount(): Call<BankruptcyLoanAmount>

    /**
     * Repay portfolio margin bankruptcy loan.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/portfolio/repay")
    @Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
    fun repay(): Call<RepayResponse>
}