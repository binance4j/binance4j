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
import com.binance4j.core.interceptor.MetaHeadersInterceptor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * A base client for the Binance API
 *
 * [See: doc](https://binance-docs.github.io/apidocs/spot/en/#endpoint-security-type)
 */
abstract class RestClient<T>(var mapping: Class<T>, var key: String, var secret: String, var useTestnet: Boolean = false) {
    /** URL base domain.  */
    private var baseDomain = "api.binance.com"

    /** Testnet URL base domain.  */
    private var testnetDomain = "testnet.binance.vision"

    /** Request authentication interceptor */
    private var interceptor: AuthenticationInterceptor

    /** The current API service  */
    protected var service: T


    init {
        interceptor = AuthenticationInterceptor(key, secret)
        service = createService()
    }

    companion object {
        /** The Jackson object mapper for deserialization.  */
        fun mapper(): ObjectMapper = ObjectMapper()
    }

    /** Generates the API service.  */
    private fun createService(): T {
        mapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val converterFactory = JacksonConverterFactory.create(mapper())
        val dispatcher = Dispatcher()
        val httpClient = OkHttpClient.Builder().dispatcher(dispatcher).build()
        val apiUrl = if (useTestnet) "https://$testnetDomain" else "https://$baseDomain"
        val client = httpClient.newBuilder().addInterceptor(interceptor)
            .addInterceptor(MetaHeadersInterceptor()).build()
        return Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build()
            .create(mapping)
    }

    /**
     * Updates the API keys.
     *
     * @param key    New public key.
     * @param secret New secret key.
     */
    fun updateKeys(key: String, secret: String) {
        this.key = key
        this.secret = secret
        // We also update the authentication interceptor keys
        interceptor.updateKeys(key, secret)
    }
}