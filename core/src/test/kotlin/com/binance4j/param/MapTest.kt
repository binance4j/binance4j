package com.binance4j.param

import com.binance4j.core.annotation.Param
import com.binance4j.core.param.Params
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MapTest {
    @Test
    fun testCustom() {
        val params = CustomParams()
        params.foo = "string"
        params.bar = 2
        val map: Map<String, Any> = params.toMap()
        Assertions.assertEquals(map["foo"], params.foo)
        Assertions.assertEquals(map["bar"], params.bar)
        Assertions.assertNotNull(map["timestamp"])
        Assertions.assertNotNull(map["recvWindow"])
    }

    @Test
    fun testNoTimestamp() {
        val map: Map<String, Any> = NoTimestampParams().toMap()
        Assertions.assertFalse(map.containsKey("timestamp"))
        Assertions.assertFalse(map.containsKey("recvWindow"))
    }

    @Param
    internal inner class CustomParams : Params {
        var foo: String? = null
        var bar = 0
    }

    @Param(recvWindow = false, timestamp = false)
    internal inner class NoTimestampParams : Params
}