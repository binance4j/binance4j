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
package com.binance4j.connectors.vision.param

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.callback.ApiCallback
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.exception.NotFoundException
import com.binance4j.connectors.vision.dto.VisionChecksum
import okhttp3.ResponseBody
import retrofit2.Call
import java.util.*

/**
 * Vision data checksum request
 * @param call API call.
 */
class ChecksumParams(call: Call<ResponseBody>) : Request<ResponseBody>(call) {

    /**
     * Retrieves the checksum from the response body
     *
     * @param res Response body.
     * @return The checksum wrapper.
     */
    private fun resToChecksum(res: ResponseBody): VisionChecksum {
        val sc = Scanner(res.byteStream())
        var data = arrayOf("")
        while (sc.hasNextLine()) {
            val line = sc.nextLine()
            data = line.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }
        sc.close()
        return VisionChecksum(data[0], data[1])
    }

    /**
     *  Downloads the checksum synchronously

     * @return The checksum.
     * @throws ApiException Thrown if data fetching failed.
     */
    @Throws(ApiException::class)
    fun getChecksum(): VisionChecksum = resToChecksum(sync())


    /**
     * Downloads the checksum asynchronously
     *
     * @param callback Callback handling the deserialized data and the API response
     * error.
     */
    fun getChecksum(callback: ApiCallback<VisionChecksum>) =
        async { res: ResponseBody?, e: ApiException? -> callback(resToChecksum(res!!), e) }

    @Throws(ApiException::class)
    override fun sync(): ResponseBody {
        return try {
            super.sync()
        } catch (e: Exception) {
            throw NotFoundException()
        }
    }
}