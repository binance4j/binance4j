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

package com.binance4j.core.interceptor

import com.binance4j.core.Binance4j.ORDER_H
import com.binance4j.core.Binance4j.RATE_LIMIT_H
import com.binance4j.core.Binance4j.WEIGHT_H
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Interceptor to remove metadata headers before sending the request.
 */
class MetaHeadersInterceptor : Interceptor {
	/**
	 * Intercepts the request
	 *
	 * @param chain Request chain.
	 */
	@Throws(IOException::class)
	override fun intercept(chain: Interceptor.Chain): Response {
		val builder =
			chain.request().newBuilder().removeHeader(ORDER_H).removeHeader(RATE_LIMIT_H).removeHeader(WEIGHT_H)
		return chain.proceed(builder.build())
	}
}