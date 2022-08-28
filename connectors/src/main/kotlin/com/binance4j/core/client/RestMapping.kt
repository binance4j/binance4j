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

import com.binance4j.core.interceptor.AuthenticationInterceptor

/** Base interface for API Mapping.  */
interface RestMapping {
    companion object {
        /** The signed http full header.  */
        const val SIGNED_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER

        /** The API key http full header.  */
        const val API_H = AuthenticationInterceptor.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER

        /** Header name to determine if request is an order  */
        const val ORDER_H = "X-ORDER"

        /** Header to tell that this request is an order.  */
        const val IS_ORDER_H = "$ORDER_H: #"

        /** Header name to determine the rate limit type.  */
        const val RATE_LIMIT_H = "X-LIMIT"

        /** IP limited header for rate limiter interceptor. */
        const val IP_H = "$RATE_LIMIT_H: IP"

        /** UID limited header for rate limiter interceptor. */
        const val UID_H = "$RATE_LIMIT_H: UID"

        /** UID and IP limited header for rate limiter interceptor. */
        const val IP_UID_H = "$RATE_LIMIT_H: IP_UID"

        /** Request weight header.  */
        const val WEIGHT_H = "X-WEIGHT"

        /** Request with a weight of one.  */
        const val WEIGHT_ONE_H = "$WEIGHT_H: 1"
    }
}