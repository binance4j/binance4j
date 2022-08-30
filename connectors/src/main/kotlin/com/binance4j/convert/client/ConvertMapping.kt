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

package com.binance4j.convert.client

import com.binance4j.convert.dto.ConversionHistory
import com.binance4j.core.Binance4j.IP_H
import com.binance4j.core.Binance4j.SIGNED_H
import com.binance4j.core.Binance4j.WEIGHT_H
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

/** [ConvertClient] mapping.  */
interface ConvertMapping {
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/convert/tradeFlow")
	@Headers(SIGNED_H, IP_H, "$WEIGHT_H: 3000")
	@JvmSuppressWildcards
	fun getConversions(@QueryMap map: Map<String, Any>): Call<ConversionHistory>
}