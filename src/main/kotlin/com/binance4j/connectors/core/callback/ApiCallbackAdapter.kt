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

package com.binance4j.connectors.core.callback

import com.binance4j.connectors.core.exception.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * Triggered when the receiving a response from the server.
 *
 * - response  : API response.
 * - exception : Exception response sent by the Binance API.
 */
typealias ApiCallback<T> = (response: T?, exception: ApiException?) -> Unit

/** A wrapper for [ApiCallback].  */
class ApiCallbackAdapter<T>(val callback: ApiCallback<T>) : Callback<T> {

    /**
     * Calls [ApiCallback] corresponding method according to the response HTTP code
     *
     * @param call     Retrofit call.
     * @param res API response.
     */
    override fun onResponse(call: Call<T>, res: Response<T>) {
        when (res.code()) {
            200 -> callback(res.body(), null)
            403 -> callback(null, FirewallViolationException())
            404 -> callback(null, NotFoundException())
            418 -> callback(null, ApiBanException())
            429 -> callback(null, RateLimitExcessException())
            else -> {
                try {
                    callback(null, ApiException(res.code(), res.errorBody()!!.string()))
                } catch (e: IOException) {
                    callback(null, ApiException(-400, e.localizedMessage))
                }
            }
        }
    }

    /**
     * Generates an [ApiException] from the given Throwable and calls [ApiCallback]
     *
     * @param call      Retrofit call.
     * @param throwable API error message.
     */
    override fun onFailure(call: Call<T>, throwable: Throwable) = callback(null, ApiException(-1000, throwable.localizedMessage))
}