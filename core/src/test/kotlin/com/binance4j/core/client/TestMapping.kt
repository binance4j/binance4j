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
package com.binance4j.core.client

import com.binance4j.core.dto.VoidResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TestMapping : RestMapping {
    @GET(BASE + "ping")
    @Headers("X-WEIGHT: 3", RestMapping.IP_H, RestMapping.IS_ORDER_H, RestMapping.SIGNED_H)
    @JvmSuppressWildcards
    fun ping(): Call<VoidResponse>

    @GET(BASE + "time")
    @Headers("X-WEIGHT: 5", RestMapping.IP_H, RestMapping.SIGNED_H)
    @JvmSuppressWildcards
    fun time(): Call<ServerTimeResponse>

    @GET(BASE + "notfound")
    @Headers("X-WEIGHT: 5", RestMapping.IP_H, RestMapping.SIGNED_H)
    @JvmSuppressWildcards
    fun notFound(): Call<VoidResponse>

    companion object {
        const val BASE = "/api/v3/"
    }
}