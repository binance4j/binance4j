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

import com.binance4j.core.Request
import com.binance4j.core.client.RestClient
import com.binance4j.spot.dto.OrderInfo
import com.binance4j.spot.param.*

/**
 * API client for the SPOT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade)
 */
object SpotClient : RestClient<SpotMapping>(SpotMapping::class.java) {
	fun testnet(testnet: Boolean) = createService(SpotMapping::class.java, testnet)
	
	/**
	 * Sends an order.
	 *
	 * @param order The order to send.
	 */
	fun newOrder(order: NewOrder) = Request(service.newOrder(order.toMap()))
	
	/**
	 * Sends an order.
	 *
	 * @param order The order to send.
	 */
	fun newOrderTest(order: NewOrder) = Request(service.newOrderTest(order.toMap()))
	
	/**
	 * Cancel an active order.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOrder(params: CancelOrderParams) = Request(service.cancelOrder(params.toMap()))
	
	/**
	 * Cancels all active orders on a symbol. This includes OCO orders.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOpenOrders(params: CancelOpenOrdersParams) = Request(service.cancelOpenOrders(params.toMap()))
	
	/**
	 * Check an order's status.
	 *
	 * Either orderId or origClientOrderId must be sent.
	 * For some historical orders cumulative quote quantity will be &lt; 0, meaning the data is not available at this time.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOrderStatus(params: OrderStatusParams): Request<OrderInfo> = Request(service.getOrderStatus(params.toMap()))
	
	/**
	 * Get all open orders on a symbol.
	 *
	 * @param params Request params.
	 *
	 * @return The request to execute.
	 */
	fun getOpenOrders(params: OpenOrdersStatusParams) = Request(service.getOpenOrders(params.toMap()))
	
	/**
	 * Get all open orders.
	 *
	 * @return The request to execute.
	 */
	fun getOpenOrders(): Request<List<OrderInfo>> = Request(service.getOpenOrders(OpenOrdersStatusParams().toMap()))
	
	/**
	 * Get all orders on a symbol.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getAllOrders(params: AllOrdersParams) = Request(service.getAllOrders(params.toMap()))
	
	/**
	 * Send in an OCO order.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun newOCO(params: NewOCOOrder) = Request(service.newOCO(params.toMap()))
	
	/**
	 * Cancel an entire Order List. Canceling an individual leg will cancel the
	 * entire OCO
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun cancelOCO(params: CancelOCOParams) = Request(service.cancelOCO(params.toMap()))
	
	/**
	 * Retrieves a specific OCO based on provided optional parameters.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getOCO(params: OCOInfoParams) = Request(service.queryOCO(params.toMap()))
	
	/**
	 * Retrieves all OCO based on provided optional parameters.
	 *
	 * @param params    Request params.
	 * @return The request to execute.
	 */
	fun getAllOCO(params: AllOCOInfoParams = AllOCOInfoParams()) = Request(service.getAllOCO(params.toMap()))
	
	/**
	 * Retrieves all open OCO.
	 *
	 * @return The request to execute.
	 */
	fun getOpenOCO() = Request(service.getOpenOCO(OpenOCOParams().toMap()))
	
	/**
	 * Get current account information.
	 *
	 * @return The request to execute.
	 */
	fun getAccount() = Request(service.getAccount(AccountParams().toMap()))
	
	/**
	 * Get trades for a specific account and symbol. If fromId is set, it will get
	 * id &gt;= fromId. Otherwise, most recent trades are returned.
	 *
	 * @param params Request params.
	 * @return The request to execute.
	 */
	fun getTrades(params: TradesParams) = Request(service.getTrades(params.toMap()))
	
	/**
	 * Displays the user's current order count usage for all intervals with default
	 * request
	 *
	 * @return The request to execute.
	 */
	fun getOrderCount() = Request(service.getOrderCount(OrderCountParams().toMap()))
}