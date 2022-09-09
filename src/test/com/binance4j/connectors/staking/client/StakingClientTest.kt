package com.binance4j.connectors.staking.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.staking.dto.ProductType
import com.binance4j.connectors.staking.dto.TransactionType
import org.junit.jupiter.api.Test

internal class StakingClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).staking

    @Test
    fun `Get staking products`() = ProductType.values().forEach { value -> assertDoesNotThrow(client.getProducts(value)) }

    //@Test TODO unquote to test
    //fun purchase() = assertDoesNotThrow(client.purchase(ProductType.STAKING, "asset","amount"))

    //@Test TODO unquote to test
    //fun redeem() = assertDoesNotThrow(client.redeem(ProductType.STAKING, "asset", amount = "amount"))

    @Test
    fun `Get all products position`() = ProductType.values().forEach { value -> assertDoesNotThrow(client.getPosition(value)) }

    @Test
    fun getHistory() = ProductType.values().forEach { product ->
        TransactionType.values().forEach { transaction ->
            assertDoesNotThrow(client.getHistory(product, transaction))
        }
    }

    //@Test TODO unquote to test
    //fun setAutoStaking() = assertDoesNotThrow(client.setAutoStaking(ProductType.STAKING,"positionId",true))

    @Test
    fun getLeftQuota() = assertDoesNotThrow(client.getLeftQuota(ProductType.STAKING, "Cake*120"))
}