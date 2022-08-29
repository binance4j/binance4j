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

import com.binance4j.core.Binance4j
import com.binance4j.core.interceptor.AuthenticationInterceptor
import com.binance4j.core.interceptor.MetaHeadersInterceptor
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * A base client for the Binance API.
 *
 * @param T The Retrofit2 mapping type.
 * @param mapping The Retrofit2 mapping.
 * @param key The API key.
 * @param secret The API secret.
 * @param useTestnet Should the client use the Test Network?
 *
 * [See: doc](https://binance-docs.github.io/apidocs/spot/en/#endpoint-security-type)
 */
abstract class RestClient<T> @JvmOverloads constructor(
	mapping: Class<T>,
	key: String = "",
	secret: String = "",
	useTestnet: Boolean = false
) {
	/** Request authentication interceptor. */
	private var interceptor: AuthenticationInterceptor = AuthenticationInterceptor()
	
	/** API service to make calls.  */
	protected var service: T = createService(mapping, useTestnet)
	
	/** Generates the API service.
	 *
	 * @param mapping The Retrofit2 mapping.
	 * @param useTestnet Should the client use the Test Network?
	 */
	private fun createService(mapping: Class<T>, useTestnet: Boolean): T {
		val apiUrl = if (useTestnet) "https://testnet.binance.vision" else "https://api.binance.com"
		val converterFactory = JacksonConverterFactory.create(Binance4j.MAPPER)
		val client = OkHttpClient.Builder().dispatcher(Dispatcher()).build().newBuilder().addInterceptor(interceptor)
			.addInterceptor(MetaHeadersInterceptor()).build()
		return Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build()
			.create(mapping)
	}
	
	/**
	 * Updates the authentication interceptor's API keys.
	 *
	 * @param key    New key.
	 * @param secret New secret.
	 */
	fun updateKeys(key: String, secret: String) {
		interceptor.key = key
		interceptor.secret = secret
	}
}