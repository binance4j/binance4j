/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.spot.client

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.market.service.ExchangeInfoService
import com.binance4j.connectors.spot.dto.NewOrder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class SpotClientTest : CustomTest() {
    private var symbolInfoService = ExchangeInfoService.getSymbolInfoService(symbol)!!
    private var quantity = symbolInfoService.symbolInfo.filters.lotSize.minQty
    private var minNotional = symbolInfoService.symbolInfo.filters.minNotional.minNotional
    private var client: SpotClient = Connectors.rest(testnetKey, testnetSecret).spot.testnet(true)
    private var price = Connectors.rest.market.getAveragePrice(symbol).sync().price
    private var ocoQuantity = "0.01"
    private var ocoPrice = "22000"
    private var ocoStopPrice = "23500"
    private var ocoSymbol = "BTCUSDT"
    private var orderId = 0L
    private var orderListId = 0L

    @Test
    @Order(0)
    fun testNewOrderTest() {
        assertDoesNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.BUY, quantity)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.SELL, quantity)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.BUY, minNotional)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.SELL, minNotional)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.BUY, quantity, price, TimeInForce.FOK)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.SELL, quantity, price, TimeInForce.FOK)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.BUY, quantity, price)))
        assertDoesNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.SELL, quantity, price)))
        assertDoesNotThrow(
            client.newOrderTest(
                NewOrder.takeProfitLimit(
                    symbol, OrderSide.BUY, quantity, price, timeInForce = TimeInForce.FOK, stopPrice =
                    price
                )
            )
        )
        assertDoesNotThrow(
            client.newOrderTest(
                NewOrder.takeProfitLimit(
                    symbol, OrderSide.SELL, quantity, price, timeInForce = TimeInForce.FOK, stopPrice =
                    price
                )
            )
        )
    }

    @Test
    @Order(1)
    fun testNewOrderMarket() {
        assertDoesNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.BUY, quantity)))
        assertDoesNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.SELL, quantity)))
    }

    @Test
    @Order(2)
    fun testNewOrderBuyLimit() = assertDoesNotThrow(client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, "0.011160", TimeInForce.GTC)))

    @Test
    @Order(3)
    fun testCancelOpenOrders() = assertDoesNotThrow(client.getOpenOrders())

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
            val buyOrder = client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, "0.011160", TimeInForce.GTC)).sync()
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
    @Order(17)
    fun testGetAllOCO3() = assertDoesNotThrow(client.getAllOCO(orderId))

    @Test
    @Order(18)
    fun testGetAllOCO4() = assertDoesNotThrow(client.getAllOCO(startTime = limit.toLong()))
}