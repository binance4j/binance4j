package com.binance4j.connectors.mining.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class MiningClientTest : CustomTest() {

    private var client = Connectors.rest(key, secret).mining

    @Test
    fun `Get all algorithms`() = assertDoesNotThrow(client.getAlgorithms())

    @Test
    fun `Get all coins`() = assertDoesNotThrow(client.getCoins())

    @Test
    fun `Gets miners details`() = assertDoesNotThrow(client.getMinersDetails(algo, "vivienld", "workerName"))

    @Test
    fun `Get miners`() = assertDoesNotThrow(client.getMiners(algo, "vivienld"))

    @Test
    fun `Get profits`() = assertDoesNotThrow(client.getProfits(algo, "vivienld"))

    @Test
    fun `Get other profits`() = assertDoesNotThrow(client.getOtherProfits(algo, "vivienld"))

    @Test
    fun `Get account profits`() = assertDoesNotThrow(client.getAccountProfits(algo, "vivienld"))

    @Test
    fun `Get hashrate resales`() = assertDoesNotThrow(client.getHashrateResales())

    @Test
    fun `Get hashrate resales in an interval`() = assertDoesNotThrow(client.getHashrateResales(1, 25))

    //@Test
    //fun `Get hashrate resales`() = assertDoesNotThrow(client.getHashrateResalesDetails())

    // @Test TODO
    //fun `Resell hashrate`() = assertDoesNotThrow(client.resellHashrate())

    //@Test TODO
    //fun `cancel Hashrate Resale Configuration`() = assertDoesNotThrow(client.cancelHashrateResaleConfiguration())

    @Test
    fun `Get statistics`() = assertDoesNotThrow(client.getStatistics(algo, "vivienld"))

    @Test
    fun `Get accounts`() = assertDoesNotThrow(client.getAccounts(algo, "vivienld"))
}