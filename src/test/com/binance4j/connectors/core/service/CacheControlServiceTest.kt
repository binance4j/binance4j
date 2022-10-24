package com.binance4j.connectors.core.service

import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.test.assertEquals

internal class CacheControlServiceTest {
    private var service: CacheControlTestService = CacheControlTestService()

    @Test
    fun `Data must be updated after expiration`() {
        service.expiration = Duration.ofSeconds(2)
        assertEquals(service.data, 1)

        Thread.sleep(1000)
        assertEquals(service.data, 1)

        Thread.sleep(1000)
        assertEquals(service.data, 2)
    }

    class CacheControlTestService : CacheControlService<Int>() {
        init {
            _data = 0
        }

        override fun fetchData(): Int = _data!! + 1
    }
}