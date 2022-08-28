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
package com.binance4j.core

import com.binance4j.core.callback.ApiCallback
import com.binance4j.core.callback.ApiCallbackAdapter
import com.binance4j.core.client.RestMapping
import com.binance4j.core.exception.ApiError
import com.binance4j.core.exception.ApiException
import com.binance4j.core.ratelimiter.RateLimiting
import com.binance4j.core.ratelimiter.RateLimiting.Companion.isEnabled
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Call
import java.io.IOException

/**
 * A class that receives and executes sync and async retrofit calls.
 */
open class Request<T>
/**
 * @param call Retrofit call.
 */(
    /**
     * The current API call.
     */
    private val call: Call<T>
) {
    // static final RateLimiter
    /**
     * Executes the request synchronously
     *
     * @return The request response.
     * @throws ApiException The exception produced with the server error response
     */
    @Throws(ApiException::class)
    open fun sync(): T {
        acquire()
        try {
            val response = call.execute()
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                assert(response.errorBody() != null)
                throw ApiException(MAPPER.readValue(response.errorBody()!!.string(), ApiError::class.java))
            }
        } catch (e: IOException) {
            throw ApiException(-400, e.message!!)
        }
    }

    /**
     * Executes the request asynchronously
     *
     * @param callback Request callback managing a success or error response.
     */
    fun async(callback: ApiCallback<T>) {
        acquire()
        call.enqueue(ApiCallbackAdapter(callback))
    }

    /**
     * Rate limits the API calls.
     */
    private fun acquire() {
        if (isEnabled) {
            if (limiters == null) limiters = RateLimiting()
            limiters!!.raw().acquire(1)
            limiters!!.weight().acquire(weight)
        }
    }

    /**
     * @return the request method
     */
    val method: String
        get() = call.request().method

    /**
     * @return the request signature
     */
    val signature: String?
        get() {
            val signedHeader = call.request().header(RestMapping.SIGNED_H)
            val apiHeader = call.request().header(RestMapping.API_H)
            return signedHeader ?: apiHeader
        }

    /** If the request is an order request. */
    val isOrder: Boolean = call.request().header(RestMapping.ORDER_H) != null

    /** The request weight */
    val weight: Int = call.request().header(RestMapping.WEIGHT_H)?.toInt() ?: 1

    /** The request rateLimit */
    val rateLimit: String = call.request().header(RestMapping.RATE_LIMIT_H) ?: "IP"

    /**
     * @return the request path
     */
    val path: String = call.request().url.toUri().path

    companion object {
        /** The Jackson Object mapper for deserializing the Api error response. */
        private val MAPPER = ObjectMapper()

        /** Rate limiting. */
        private var limiters: RateLimiting? = null
    }
}