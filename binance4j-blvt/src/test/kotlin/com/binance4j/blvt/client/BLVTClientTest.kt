package com.binance4j.blvt.client

import com.binance4j.blvt.param.*
import com.binance4j.core.exception.ApiException
import com.binance4j.core.param.TimeFrame
import com.binance4j.core.test.CustomTest
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class BLVTClientTest : CustomTest() {
    private var client = BLVTClient(key, secret)
    private var timeFrame = TimeFrame(limit)
    private var tokenName = "1INCHDOWN"
    private var amount = "1"

    init {
        client.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
        client.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLimitInfo() {
        testNotThrow(client.getLimitInfo())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetLimitInfo2() {
        testNotThrow(client.getLimitInfo(LimitInfoParams(tokenName)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetRedemptions() {
        testNotThrow(client.getRedemptions())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetRedemptionsWithTimeFrame() {
        testNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L), timeFrame))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSubscriptions() {
        testNotThrow(client.getSubscriptions())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSubscriptionsWithTimeFrame() {
        testNotThrow(client.getSubscriptions(TransactionRecordParams(tokenName), timeFrame))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTokenInfo() {
        testNotThrow(client.getTokenInfo())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTokenInfoWithParams() {
        testNotThrow(client.getTokenInfo(TokenInfoParams(tokenName)))
    }

    // NOT TEST DUE TO NEW FRENCH LAWS
    // TODO @Test
    @Throws(ApiException::class)
    fun testRedeem() {
        testNotThrow(client.redeem(RedemptionParams(tokenName, amount)))
    }

    // TODO @Test
    @Throws(ApiException::class)
    fun testSubscribe() {
        testNotThrow(client.subscribe(SubscriptionParams(tokenName, amount)))
    }

    // TODO @Test
    @Throws(ApiException::class)
    fun testGetRedemptionsWithParams() {
        testNotThrow(client.getRedemptions(TransactionRecordParams(tokenName, 0L)))
    }
}