package com.binance4j.connectors.blvt.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

/** BLVT client tests */
internal class BLVTClientTest : CustomTest(){
    private var client = Connectors.rest(key,secret).blvt
    private var tokenName = "BTCDOWN"

    @Test
    fun `Get all tokens`()  = assertDoesNotThrow(client.getTokenInfo())

    @Test
    fun `Get specific token`() = assertDoesNotThrow(client.getTokenInfo(tokenName))

    @Test
    fun `Get all subscriptions`() = assertDoesNotThrow(client.getSubscriptions())

    @Test
    fun `Get subscriptions by token name`() = assertDoesNotThrow(client.getSubscriptions(tokenName))

    @Test
    fun `Get subscriptions with time interval`() = assertDoesNotThrow(client.getSubscriptions(tokenName,null, lastYear,today, limit))

    @Test
    fun `Get all redemptions`() = assertDoesNotThrow(client.getRedemptions())

    @Test
    fun `Get redemptions by token name`() = assertDoesNotThrow(client.getRedemptions(tokenName))

    @Test
    fun `Get redemptions with time interval`() = assertDoesNotThrow(client.getRedemptions(tokenName,null, lastYear,today, limit))

    @Test
    fun `Get limit info of all tokens`() = assertDoesNotThrow(client.getLimitInfo())

    @Test
    fun `Get limit info of specific  token`() = assertDoesNotThrow(client.getLimitInfo(tokenName))

    @Test
    // TODO
    fun subscribe() {
        //assertDoesNotThrow(client.subscribe(tokenName,"1"))
    }

    @Test
    // TODO
    fun redeem() {
        //assertDoesNotThrow(client.redeem(tokenName,"1"))
    }
}