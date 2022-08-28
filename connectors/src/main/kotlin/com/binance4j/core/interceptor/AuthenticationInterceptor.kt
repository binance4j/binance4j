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

import com.binance4j.core.exception.UnableToSignException
import okhttp3.Interceptor
import okhttp3.Response
import org.apache.commons.codec.binary.Hex
import java.io.IOException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * The parameters interceptor that injects the API Key Header into requests, and
 * signs messages, whenever required.
 * @param key    API public key.
 * @param secret API private key.
 */
class AuthenticationInterceptor(var key: String, var secret: String) : Interceptor {
    /**
     * Intercepts the request
     *
     * @param chain Request chain.
     */
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequestBuilder = original.newBuilder()
        val isApiKeyRequired = original.header(ENDPOINT_SECURITY_TYPE_APIKEY) != null
        val isSignatureRequired = original.header(ENDPOINT_SECURITY_TYPE_SIGNED) != null
        newRequestBuilder.removeHeader(ENDPOINT_SECURITY_TYPE_APIKEY).removeHeader(ENDPOINT_SECURITY_TYPE_SIGNED)
        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired || isSignatureRequired) {
            newRequestBuilder.addHeader(API_KEY_HEADER, key)
        }
        // Endpoint requires signing the payload
        if (isSignatureRequired) {
            val payload = original.url.query
            if (payload != null && "" != payload) {
                val signature = sign(payload, secret)
                val signedUrl = original.url.newBuilder().addQueryParameter("signature", signature).build()
                newRequestBuilder.url(signedUrl)
            }
        }
        // Build new request after adding the necessary authentication information
        return chain.proceed(newRequestBuilder.build())
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
    }

    companion object {
        /** The API key http header.  */
        const val API_KEY_HEADER = "X-MBX-APIKEY"

        /** The API key http header decorator.  */
        const val ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY"

        /** The API key http full header.  */
        const val ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = "$ENDPOINT_SECURITY_TYPE_APIKEY: #"

        /** The signed http header decorator.  */
        const val ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED"

        /** The signed http full header.  */
        const val ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = "$ENDPOINT_SECURITY_TYPE_SIGNED: #"

        /**
         * Sign the given message using the given secret.
         *
         * @param message message to sign.
         * @param secret  secret key.
         * @return a signed message.
         */
        @JvmStatic
        @Throws(UnableToSignException::class)
        fun sign(message: String, secret: String): String {
            return try {
                val sha256HMAC = Mac.getInstance("HmacSHA256")
                val secretKeySpec = SecretKeySpec(secret.toByteArray(), "HmacSHA256")
                sha256HMAC.init(secretKeySpec)
                String(Hex.encodeHex(sha256HMAC.doFinal(message.toByteArray())))
            } catch (e: Exception) {
                throw UnableToSignException(e)
            }
        }
    }
}