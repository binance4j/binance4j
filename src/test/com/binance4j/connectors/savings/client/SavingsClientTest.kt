package com.binance4j.connectors.savings.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.savings.dto.*
import org.junit.jupiter.api.Test

internal class SavingsClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).savings

    @Test
    fun `Get flexible products`() = assertDoesNotThrow(client.getFlexibleProducts())

    @Test
    fun `Get featured flexible products`() = assertDoesNotThrow(client.getFlexibleProducts(featured = Featured.TRUE))

    @Test
    fun `Get featured flexible products in an interval`() = assertDoesNotThrow(client.getFlexibleProducts(featured = Featured.TRUE, current = 1, size = limit))

    @Test
    fun `Get Left Daily Flexible Purchase Quota`() = assertDoesNotThrow(client.getLeftDailyFlexiblePurchaseQuota("ONG001"))

    //@Test TODO unquote to test
    //fun purchaseFlexible() = assertDoesNotThrow(client.purchaseFlexible("ONG001","1"))

    @Test
    fun `Get left daily redemption quota`() = assertDoesNotThrow(client.getLeftDailyRedemptionQuota("ONG001", ProductType.NORMAL))

    //@Test TODO unquote to test
    //fun redeemFlexible() = assertDoesNotThrow(client.redeemFlexible("ONG001", "1", ProductType.NORMAL))

    @Test
    fun `Get All Flexible Products Position`() = assertDoesNotThrow(client.getFlexibleProductPosition())

    @Test
    fun `Get Flexible Product Position`() = assertDoesNotThrow(client.getFlexibleProductPosition(asset))


    @Test
    fun `Get fixed projects`() = assertDoesNotThrow(
        client.getFixedProjects(
            type = FixedProjectType.CUSTOMIZED_FIXED,
            status = FixedProjectStatus.ALL,
            sortBy = FixedProjectSorting.DURATION
        )
    )

    //@Test TODO unquote to test
    //fun purchaseFixed() = assertDoesNotThrow(client.purchaseFixed("OP", 1L))

    @Test
    fun `Get Fixed Project Position`() = assertDoesNotThrow(client.getFixedProjectPosition(status = FixedProjectPositionStatus.HOLDING))

    @Test
    fun `Get account`() = assertDoesNotThrow(client.getAccount())

    @Test
    fun `Get all purchases`() = assertDoesNotThrow(client.getPurchases(LendingType.DAILY))

    @Test
    fun `Get all redemptions`() = assertDoesNotThrow(client.getRedemptions(LendingType.DAILY))

    @Test
    fun `Get all interests`() = assertDoesNotThrow(client.getInterests(LendingType.DAILY))

    //@Test TODO unquote to test
    //fun fixedToDailyPosition() = assertDoesNotThrow(client.fixedToDailyPosition("OP", 1L))
}