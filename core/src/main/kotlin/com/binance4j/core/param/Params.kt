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

import com.binance4j.core.annotation.Param
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.http.QueryMap

/** The base of every Binance Request */
interface Params {
    /**
     * @return [ObjectMapper] responsible for deserialization.
     */
    fun mapper(): ObjectMapper {
        return defaultMapper
    }

    /**
     * @return The request receiving window.
     */
    fun recvWindow(): Long {
        return defaultRecvWindow
    }

    /**
     * @return The request timestamp in ms.
     */
    fun timestamp(): Long {
        return System.currentTimeMillis()
    }

    /**
     * @return the params into a [QueryMap] minus null and useless parameters.
     */
    fun toMap(): MutableMap<String, Any> {
        val map: MutableMap<String, Any> = mapper().convertValue(this, object : TypeReference<MutableMap<String, Any>>() {})
        // add
        if (javaClass.isAnnotationPresent(Param::class.java) && javaClass.getAnnotation(Param::class.java).timestamp) map["timestamp"] = timestamp()
        if (javaClass.isAnnotationPresent(Param::class.java) && javaClass.getAnnotation(Param::class.java).recvWindow) map["recvWindow"] = recvWindow()
        // remove
        removeFromMap(map)
        return map
    }

    /**
     * Removes values from a map.
     *
     * @param map The map to remove data from.
     */
    fun removeFromMap(map: MutableMap<String, Any>) {
        // remove
        map.remove("order")
        map.values.removeAll(setOf<Any?>(null))
        map.values.removeAll(setOf(""))
    }

    /**
     * Converts the object into a map and replace the keys names of the generated
     * map with the values of the given map.
     *
     * @param replaceMap Map used to replace the keys of the generated map. The key
     * in map2 is the key we want to change the
     * name in map1 with the value of map2.
     * @return the merged maps.
     */
    fun toMap(replaceMap: Map<String, String>): Map<String, Any> {
        val map = toMap()
        replaceMap.entries.forEach { (key, value): Map.Entry<String, String> ->
            map[value] = map[key] as Any
            map.remove(key)
        }
        removeFromMap(map)
        return map
    }

    companion object {
        /** Jackson object mapper used to convert a POJO into a [QueryMap] */
        val defaultMapper = ObjectMapper()

        /** The receiving window. */
        const val defaultRecvWindow = 60000L

        /**
         * @param maps Maps to merge into one
         * @return A map mad of all the given maps
         */
        @SafeVarargs
        fun merge(vararg maps: Map<String, Any>): Map<String, Any> {
            val map: MutableMap<String, Any> = HashMap()
            maps.forEach { m -> map.putAll(m) }
            return map
        }

        /**
         * @param maps Maps to merge into one
         * @return A map mad of all the given maps
         */
        @JvmStatic
        fun merge(vararg maps: Params): Map<String, Any> {
            val map: MutableMap<String, Any> = HashMap()
            maps.forEach { m -> map.putAll(m.toMap()) }
            return map
        }

    }
}