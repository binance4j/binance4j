package com.binance4j.connectors.core.service

import java.time.Duration

/** Abstract class to cache data. */
abstract class CacheControlService<T> {
    /** Last data fetch timestamp. */
    private var lastFetch: Long = 0L

    /** Next data fetch timestamp. */
    private var nextFetch: Long = 0L

    /** Cached data. */
    protected var _data: T? = null

    /** Period after which cached data is expired. */
    var expiration: Duration = Duration.ofHours(1)

    /**
     * @return Cached data.
     */
    val data: T
        get() {
            // Fetches data if cache is null or expired.
            if (_data == null || System.currentTimeMillis() > nextFetch) {
                _data = fetchData()
                updateCacheTimestamp()
            }
            return _data!!
        }

    /**
     * Updates the last data caching and next data caching timestamp
     */
    private fun updateCacheTimestamp() {
        lastFetch = System.currentTimeMillis()
        nextFetch = lastFetch + expiration.toMillis()
    }

    /** The method fetching data */
    abstract fun fetchData(): T
}