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
package com.binance4j.spot.client

import com.binance4j.core.Binance4j
import com.binance4j.core.dto.OrderSide
import com.binance4j.core.dto.TimeInForce
import com.binance4j.core.exception.ApiException
import com.binance4j.core.test.CustomTest
import com.binance4j.spot.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.assertEquals


@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestnetSpotClientTest : CustomTest() {
	private var page = 1
	private var client: SpotClient = TestnetSpotClient(testnetKey, testnetSecret)
	private var orderId: Long = 0
	private var quantity = "1"
	private var price = "0.011160"
	private var ocoQuantity = "0.01"
	private var ocoPrice = "22000"
	private var ocoStopPrice = "23500"
	private var ocoLimitPrice = "23500"
	private var ocoSymbol = "BTCUSDT"
	private var orderListId: Long = 0
	
	init {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Order(0)
	@Throws(ApiException::class)
	fun testNewOrderTest() {
		assertNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.BUY, "1")))
		assertNotThrow(client.newOrderTest(NewOrder.market(symbol, OrderSide.SELL, "1")))
		assertNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.BUY, "25000")))
		assertNotThrow(client.newOrderTest(NewOrder.marketQuote(symbol, OrderSide.SELL, "25000")))
		assertNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.BUY, "1", price)))
		assertNotThrow(client.newOrderTest(NewOrder.limit(symbol, OrderSide.SELL, "1", price)))
		assertNotThrow(
			client.newOrderTest(
				NewOrder.limit(
					symbol,
					OrderSide.BUY,
					"1",
					price,
					timeInForce = TimeInForce.GTC
				)
			)
		)
		assertNotThrow(
			client.newOrderTest(
				NewOrder.limit(
					symbol,
					OrderSide.SELL,
					"1",
					price,
					timeInForce = TimeInForce.GTC
				)
			)
		)
		assertNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.BUY, "1", price)))
		assertNotThrow(client.newOrderTest(NewOrder.limitMaker(symbol, OrderSide.SELL, "1", price)))
		assertNotThrow(
			client.newOrderTest(
				NewOrder.takeProfitLimit(
					symbol,
					OrderSide.BUY,
					"1",
					price,
					TimeInForce.GTC
				)
			)
		)
		assertNotThrow(
			client.newOrderTest(
				NewOrder.takeProfitLimit(
					symbol,
					OrderSide.SELL,
					"1",
					price,
					TimeInForce.GTC
				)
			)
		)
	}
	
	@Test
	@Order(1)
	@Throws(ApiException::class)
	fun testNewOrderMarket() {
		assertNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.BUY, quantity)))
		assertNotThrow(client.newOrder(NewOrder.market(symbol, OrderSide.SELL, quantity)))
	}
	
	@Test
	@Order(2)
	@Throws(ApiException::class)
	fun testNewOrderBuyLimit() {
		assertNotThrow(client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, price)))
	}
	
	@Test
	@Order(3)
	@Throws(ApiException::class)
	fun testCancelOpenOrders() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		// cancel orders
		assertNotThrow(client.cancelOpenOrders(CancelOpenOrdersParams(symbol)))
		val orders = client.getOpenOrders().sync()
		assertEquals(orders.size, 0)
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Order(4)
	@Throws(ApiException::class)
	fun testGetOpenOrders() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getOpenOrders())
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Order(5)
	@Throws(ApiException::class)
	fun testGetOrderStatus() {
		// buy
		val buyOrder = client.newOrder(NewOrder.market(symbol, OrderSide.BUY, quantity)).sync()
		// get order status
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getOrderStatus(OrderStatusParams(symbol, orderId = buyOrder.orderId)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
		// Sell
		client.newOrder(NewOrder.market(symbol, OrderSide.BUY, buyOrder.executedQty))
	}
	
	@Test
	@Order(6)
	@Throws(ApiException::class)
	fun testCancelOrder() {
		// buy limit
		val buyOrder = client.newOrder(NewOrder.limit(symbol, OrderSide.BUY, quantity, price)).sync()
		assertEquals(buyOrder.side, "BUY")
		val cancellation = client.cancelOrder(CancelOrderParams(symbol, buyOrder.orderId))
		assertNotThrow(cancellation)
		orderId = buyOrder.orderId
	}
	
	@Test
	@Order(7)
	@Throws(ApiException::class)
	fun testGetOrderCount() {
		assertNotThrow(client.getOrderCount())
	}
	
	@Test
	@Order(8)
	@Throws(ApiException::class)
	fun testGetAccount() {
		assertNotThrow(client.getAccount())
	}
	
	@Test
	@Order(9)
	@Throws(ApiException::class)
	fun testGetAllOrders() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getAllOrders(AllOrdersParams(symbol)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Order(10)
	@Throws(ApiException::class)
	fun testGetAllOrders2() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getAllOrders(AllOrdersParams(symbol, orderId)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	@Test
	@Order(11)
	@Throws(ApiException::class)
	fun testGetTrades() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		assertNotThrow(client.getTrades(TradesParams(symbol, orderId)))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	// @Test OK works!
	// @Order(12)
	@Throws(ApiException::class)
	fun testNewOCOAndGetOCO() {
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
		val oco = NewOCOOrder(
			ocoSymbol, OrderSide.BUY, ocoQuantity, ocoPrice, ocoStopPrice, ocoStopPrice,
			TimeInForce.GTC
		)
		assertNotThrow(client.newOCO(oco))
		Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
	}
	
	// @Test OK works!
	// @Order(14)
	@Throws(ApiException::class)
	fun testCancelOpenOCO() {
		client.getOpenOCO().sync().forEach { oo ->
			try {
				Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
				assertNotThrow(client.cancelOCO(CancelOCOParams(oo.symbol, oo.orderListId)))
				Binance4j.mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
			} catch (e: ApiException) {
				e.printStackTrace()
			}
		}
	}
	
	@Test
	@Order(15)
	@Throws(ApiException::class)
	fun testGetAllOCO() {
		assertNotThrow(client.getAllOCO())
	}
	
	@Test
	@Order(16)
	@Throws(ApiException::class)
	fun testGetAllOCO2() {
		assertNotThrow(client.getAllOCO(AllOCOInfoParams(orderId)))
	}
	
	@Test
	@Order(17)
	@Throws(ApiException::class)
	fun testGetAllOCO3() {
		assertNotThrow(client.getAllOCO(AllOCOInfoParams(orderId, limit = limit)))
	}
	
	@Test
	@Order(18)
	@Throws(ApiException::class)
	fun testGetAllOCO4() {
		assertNotThrow(client.getAllOCO(AllOCOInfoParams()))
	}
}