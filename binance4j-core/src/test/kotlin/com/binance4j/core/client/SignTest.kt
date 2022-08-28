package com.binance4j.core.client

import com.binance4j.core.interceptor.AuthenticationInterceptor.Companion.sign
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SignTest {
    @Test
    fun testSignature() {
        Assertions.assertDoesNotThrow {
            val signature = sign("Hello World!", "keyboard cat")
            Assertions.assertNotNull(signature)
        }
    }
}