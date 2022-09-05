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
import okhttp3.ResponseBody
import retrofit2.Call
import java.io.IOException
import java.util.*
import java.util.zip.ZipInputStream


/** Base executor implementation for the public data enpoint  */
abstract class VisionParams<T>
/**
 * @param call API call.
 */
protected constructor(call: Call<ResponseBody>) : Request<ResponseBody>(call) {
	/**
	 * Downloads the zip file synchronously
	 *
	 * @return The zip file.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	fun getZip(): ZipInputStream = try {
		responseToZip(sync())
	} catch (e: ApiException) {
		throw NotFoundException()
	}
	
	/**
	 * Downloads the zip file asynchronously
	 *
	 * @param callback Callback handling the deserialized data and the API response
	 * error.
	 */
	open fun getZip(callback: ApiCallback<ZipInputStream>) {
		async { res: ResponseBody?, exc: ApiException? -> callback.onResponse(responseToZip(res!!), exc) }
	}
	
	
	/**
	 * Downloads the zip file synchronously and returns the data in a csv style (2d
	 * list)
	 *
	 * @return The deserialized data.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	fun getCSV(): List<List<String>> = extractCSV(getZip())
	
	/**
	 * Downloads the zip file asynchronously and returns the data in a csv style (2d
	 * list)
	 *
	 * @param callback Callback handling the deserialized data and the API response
	 * error.
	 */
	fun getCSV(callback: ApiCallback<List<List<String>>>) {
		async { res: ResponseBody?, _ ->
			try {
				callback.onResponse(extractCSV(responseToZip(res!!)), null)
			} catch (ex: ApiException) {
				callback.onResponse(null, ex)
			}
		}
	}
	
	/**
	 * Downloads the zip file synchronously and returns the data in the csv as a
	 * list of objects
	 *
	 * @return The deserialized data.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	fun getData(): List<T> = csvToObject(getCSV())
	
	/**
	 * Downloads the zip file asynchronously and returns the data in the csv as a
	 * list of objects
	 *
	 * @param callback Callback handling the deserialized data and the API response
	 * error.
	 */
	fun getData(callback: ApiCallback<List<T>>) {
		async { res: ResponseBody?, _ ->
			try {
				callback.onResponse(csvToObject(extractCSV(responseToZip(res!!))), null)
			} catch (ex: ApiException) {
				callback.onResponse(null, ex)
			}
		}
	}
	
	/**
	 * Converts the responseBody into a zip stream
	 *
	 * @param res ResponseBody.
	 * @return The zip stream.
	 */
	private fun responseToZip(res: ResponseBody): ZipInputStream {
		return ZipInputStream(res.byteStream())
	}
	
	/**
	 * Extracts the csv from the zip
	 *
	 * @param zis Zip stream.
	 * @return The data as a list of string arrays.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	protected fun extractCSV(zis: ZipInputStream): List<List<String>> {
		return try {
			val data: MutableList<List<String>> = ArrayList()
			val sc = Scanner(zis)
			zis.nextEntry
			while (sc.hasNextLine()) {
				data.add(listOf(*sc.nextLine().split(",".toRegex()).dropLastWhile { it.isEmpty() }
					.toTypedArray()))
			}
			sc.close()
			data
		} catch (e: IOException) {
			throw ApiException(-400, e.message!!)
		}
	}
	
	/**
	 * Converts the csv into a list of the desired type
	 *
	 * @param clazz Object class
	 * @param input Data as a list of string arrays.
	 * @return The data as a list of objects.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	protected fun csvToObject(clazz: Class<T>, input: List<List<String>>): List<T> {
		val obj: MutableList<T> = ArrayList()
		for (csv in input) {
			try {
				// The class must have a constructor that accepts a 2d list
				obj.add(clazz.getConstructor(MutableList::class.java).newInstance(csv))
			} catch (e: Exception) {
				throw ApiException(-300, e.message!!)
			}
		}
		return obj
	}
	
	/**
	 * The child class method to convert the csv list into a list of the generic
	 * type
	 *
	 * @param input Csv input.
	 * @return A list of.
	 * @throws ApiException Thrown if data fetching failed
	 */
	@Throws(ApiException::class)
	protected abstract fun csvToObject(input: List<List<String>>): List<T>
}