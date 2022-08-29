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
package com.binance4j.core.param

import com.binance4j.core.Binance4j
import com.fasterxml.jackson.core.type.TypeReference

/** The base of every Binance Request */
interface Params {
	/** @return The request timestamp */
	
	fun timestamp() = System.currentTimeMillis()
	
	/** @return The receiving windows */
	
	fun recvWindow(): Long = 60_000L
	
	/**
	 * Converts the object into a map and replace the keys names of the generated
	 * map with the values of the given map.
	 *
	 * @param replaceMap Map used to replace the keys of the generated map. The key in map2 is the key we want to change the name in map1 with the value of map2.
	 * @return the merged maps.
	 */
	fun toMap(replaceMap: Map<String, String>? = null): Map<String, Any> {
		val map: MutableMap<String, Any> =
			Binance4j.MAPPER.convertValue(this, object : TypeReference<MutableMap<String, Any>>() {})
		// remove useless entries
		map.remove("order")
		map.values.removeAll(setOf<Any?>(null))
		map.values.removeAll(setOf(""))
		
		replaceMap!!.entries.forEach { (key, value): Map.Entry<String, String> ->
			map[value] = map[key] as Any
			map.remove(key)
		}
		return map
	}
}