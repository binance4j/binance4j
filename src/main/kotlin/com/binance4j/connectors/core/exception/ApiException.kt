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

package com.binance4j.connectors.core.exception

import com.binance4j.connectors.core.Request

/** API response error containing a code and a message.  */
data class ApiError(val code: Int = 0, val msg: String = "")

/**
 * An exception which can occur while invoking methods of the Binance API.
 * @param code    API response code.
 * @param message API response message.
 */
open class ApiException @JvmOverloads constructor(val code: Int = 0, override val message: String = "Unexpected Exception") : Exception(message) {
    constructor(error: ApiError) : this(error.code, error.msg)
}

/** Thrown when a deserialization has failed  */
class DeserializationException : ApiException(-1007, "Deserialization failed")

/** Thrown when The Web Application Firewall has been violated.  */
class FirewallViolationException : ApiException(403, "The Web Application Firewall has been violated")

/** Thrown when given date is invalid.  */
class InvalidDateException : ApiException(-500, "Date is invalid")

/** Thrown when a mandatory param is missing in a request.  */
class MandatoryParamException : ApiException(-3000, "A mandatory param is missing in the request")

/** Thrown when data was not found.  */
class NotFoundException : ApiException(404, "Not Found")

/**
 * Thrown when data is null.
 * @param data The null data.
 */
class NullException(data: String) : ApiException(404, data)

/** Thrown when rate limit is exceeded.  */
class RateLimitExcessException : ApiException(429, "Request rate limit exceeded")

/**
 * Runtime exception thrown if the [Request] can't sign the API keys
 * @param e Original exception
 */
class UnableToSignException(e: Exception) : RuntimeException("Unable to sign message.", e)

/** Thrown when Banned by API for too many API rate limit excess.  */
class ApiBanException : ApiException(418, "IP has been auto-banned for continuing to send requests after receiving 429 codes")