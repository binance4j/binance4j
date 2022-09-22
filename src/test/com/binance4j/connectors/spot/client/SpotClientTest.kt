package com.binance4j.connectors.spot.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.spot.dto.NewOrder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class SpotClientTest : CustomTest() {
    private var page = 1
    private var client: SpotClient = Connectors.rest(key, secret).spot.testnet(true)
    private var orderId: Long = 0
    private var quantity = "1"
    private var price = "0.011160"
    private var ocoQuantity = "0.01"
    private var ocoPrice = "22000"
    private var ocoStopPrice = "23500"
    private var ocoLimitPrice = "23500"
    private var ocoSymbol = "BTCUSDT"
    private var orderListId: Long = 0

    @Test
    @Order(0)

    fun testNewOrderTest() {
        assertDoesNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.BUY, "1")))
        assertDoesNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.SELL, "1")))
        assertDoesNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.BUY, "25000")))
        assertDoesNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.SELL, "25000")))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.BUY, "1", price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.SELL, "1", price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.BUY, "1", price, timeInForce = TimeInForce.FOK)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.SELL, "1", price, timeInForce = TimeInForce.FOK)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.BUY, "1", price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.SELL, "1", price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.takeProfitLimit(symbol, OrderSide.BUY, "1", price, timeInForce = TimeInForce.FOK, stopPrice = price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.takeProfitLimit(symbol, OrderSide.SELL, "1", price, timeInForce = TimeInForce.FOK, stopPrice = price)))
    }

    @Test
    @Order(1)
    fun testNewOrderMarket() {
        assertDoesNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.BUY, quantity)))
        assertDoesNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.SELL, quantity)))
    }

    @Test
    @Order(2)
    fun testNewOrderBuyLimit() = assertDoesNotThrow(client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, "0.011160")))

    @Test
    @Order(3)

    fun testCancelOpenOrders() {
        // cancel orders
        Assertions.assertDoesNotThrow {
            val orders = client.getOpenOrders().sync()
            assertEquals(orders.size, 0)
        }
    }

    @Test
    @Order(4)
    fun testGetOpenOrders() = assertDoesNotThrow(client.getOpenOrders())

    @Test
    @Order(5)
    fun testGetOrderStatus() {
        // buy
        val buyOrder = client.newOrder(NewOrder.market(symbol, OrderSide.BUY, quantity)).sync()
        // get order status
        assertDoesNotThrow(client.getOrderStatus(symbol, buyOrder.orderId.toString()))
        // sell
        client.newOrder(NewOrder.market(symbol, OrderSide.SELL, buyOrder.executedQty))
    }

    @Test
    @Order(6)
    fun testCancelOrder() {
        Assertions.assertDoesNotThrow {
            // buy limit
            val buyOrder = client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, "0.011160")).sync()
            assertEquals(buyOrder.side, "BUY")
            val cancellation = client.cancelOrder(symbol, buyOrder.orderId).sync()
            orderId = buyOrder.orderId
        }
    }

    @Test
    @Order(7)
    fun testGetOrderCount() = assertDoesNotThrow(client.getOrderCount())

    @Test
    @Order(8)
    fun testGetAccount() = assertDoesNotThrow(client.getAccount())

    @Test
    @Order(9)

    fun testGetAllOrders() = assertDoesNotThrow(client.getAllOrders(symbol))

    @Test
    @Order(10)
    fun testGetAllOrders2() = assertDoesNotThrow(client.getAllOrders(symbol, orderId))

    @Test
    @Order(11)
    fun testGetTrades() = assertDoesNotThrow(client.getTrades(symbol, orderId))

    // @Test OK works!
    // @Order(12)
    fun testNewOCOAndGetOCO() {
        Assertions.assertDoesNotThrow {
            val res = client.newOCO(ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice, ocoStopPrice, TimeInForce.GTC).sync()
            orderListId = res.orderListId
            assertDoesNotThrow(client.getOCO(orderListId = res.orderListId))
        }
    }

    // @Test OK works!
    // @Order(14)
    fun testCancelOpenOCO() {
        client.getOpenOCO().sync().forEach { oo ->
            try {
                client.cancelOCO(oo.symbol, oo.orderListId).sync()
            } catch (e: ApiException) {
                Assertions.fail()
            }
        }
    }

    @Test
    @Order(15)
    fun testGetAllOCO() = assertDoesNotThrow(client.getAllOCO())

    @Test
    @Order(16)
    fun testGetAllOCO2() = assertDoesNotThrow(client.getAllOCO(orderId))

    @Test
    @Order(17)
    fun testGetAllOCO3() = assertDoesNotThrow(client.getAllOCO(orderId, startTime = limit.toLong()))

    @Test
    @Order(18)
    fun testGetAllOCO4() = assertDoesNotThrow(client.getAllOCO(startTime = limit.toLong()))
}