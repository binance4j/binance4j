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

package com.binance4j.connectors.spot.service

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.dto.OrderType
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.market.dto.SymbolInfo
import com.binance4j.connectors.market.service.ExchangeInfoService
import com.binance4j.connectors.spot.dto.NewOrder

/** Service giving additional info about a [NewOrder]. */
object NewOrderService {
    /**
     * @param symbol symbol to get average price.
     * @return Symbol average price.
     */
    @Throws(ApiException::class)
    private fun getAveragePrice(symbol: String) = Connectors.rest.market.getAveragePrice(symbol).sync().price

    /**
     * @param order The order to verify.
     * @param symbolInfo The symbol info containing the filter.
     * @return The right lot size filter according to the order type.
     */
    private fun getLotSizeFilter(order: NewOrder, symbolInfo: SymbolInfo) =
        if (order.type == OrderType.MARKET) symbolInfo.filters.marketLotSize else symbolInfo.filters.lotSize

    /**
     * @param order The order to get the price from.
     * @return The order price.
     * @throws NullPointerException Price is missing.
     */
    @Throws(NullPointerException::class)
    private fun getOrderPrice(order: NewOrder) = order.price ?: throw NullPointerException("price")

    /**
     * @param order The order to get the quantity from.
     * @return The order quantity.
     * @throws NullPointerException Quantity is missing.
     */
    @Throws(NullPointerException::class)
    private fun getOrderQuantity(order: NewOrder) = order.quantity ?: throw NullPointerException("quantity")

    /**
     * @param symbol The symbol we want the [SymbolInfo].
     * @return The symbol's [SymbolInfo] in the [ExchangeInfoService] cached info.
     * @throws NullPointerException [SymbolInfo] is missing.
     */
    @Throws(NullPointerException::class)
    private fun getSymbolInfo(symbol: String): SymbolInfo = ExchangeInfoService.getSymbolInfo(symbol) ?: throw NullPointerException("symbol")

    // Price validation

    /**
     * @param order The order to verify.
     * @return If the order price is inferior to the symbol's minimal price filter or percent price filter.
     * @throws NullPointerException price or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun isPriceTooLow(order: NewOrder): Boolean {
        val info = getSymbolInfo(order.symbol)
        val orderPrice = getOrderPrice(order).toBigDecimal()
        val minPrice = info.filters.price.minPrice.toBigDecimal()
        val avgPrice = getAveragePrice(order.symbol).toBigDecimal()
        val isBelowMinPrice = orderPrice.compareTo(minPrice) == -1
        val isBelowDownPrice = orderPrice.compareTo(avgPrice.multiply(info.filters.percentPrice.multiplierDown.toBigDecimal())) == -1
        return isBelowMinPrice || isBelowDownPrice
    }

    /**
     * @param order The order to verify.
     * @return If the order price is superior to the symbol's maximal price filter or percent price filter.
     * @throws NullPointerException price or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun isPriceTooHigh(order: NewOrder): Boolean {
        val info = getSymbolInfo(order.symbol)
        val orderPrice = getOrderPrice(order).toBigDecimal()
        val maxPrice = info.filters.price.maxPrice.toBigDecimal()
        val avgPrice = getAveragePrice(order.symbol).toBigDecimal()
        val isAboveMaxPrice = orderPrice.compareTo(maxPrice) == 1
        val isAboveUpPrice = orderPrice.compareTo(avgPrice.multiply(info.filters.percentPrice.multiplierUp.toBigDecimal())) == 1
        return isAboveMaxPrice || isAboveUpPrice
    }

    /**
     * @param order The order to verify.
     * @return If the order price is valid.
     * @throws NullPointerException price or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun validatePrice(order: NewOrder): Boolean = !isPriceTooHigh(order) && !isPriceTooLow(order)

    // Quantity validation

    /**
     * @param order The order to verify.
     * @return If the order quantity is below the lot size filter min quantity.
     * @throws NullPointerException quantity or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun isQuantityTooLow(order: NewOrder): Boolean =
        getOrderQuantity(order).toBigDecimal().compareTo(getSymbolInfo(order.symbol).filters.lotSize.minQty.toBigDecimal()) == -1

    /**
     * @param order The order to verify.
     * @return If the order quantity is above the lot size filter max quantity.
     * @throws NullPointerException quantity or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun isQuantityTooHigh(order: NewOrder): Boolean =
        getOrderQuantity(order).toBigDecimal().compareTo(getLotSizeFilter(order, getSymbolInfo(order.symbol)).maxQty.toBigDecimal()) == 1

    /**
     * @param order The order to verify.
     * @return If the order quantity is valid.
     * @throws NullPointerException quantity or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun validateQuantity(order: NewOrder): Boolean = !isQuantityTooHigh(order) && !isQuantityTooLow(order)

    /**
     * @param order The order to verify.
     * @return If the quote order quantity is below the min notional filter.
     * @throws NullPointerException quoteOrderQty or symbol is null (told in message).
     */
    @Throws(NullPointerException::class)
    fun isQuoteQuantityTooLow(order: NewOrder): Boolean {
        if (order.quoteOrderQty == null) throw NullPointerException("quoteOrderQty")
        return order.quoteOrderQty!!.toBigDecimal().compareTo(getSymbolInfo(order.symbol).filters.minNotional.minNotional.toBigDecimal()) == -1
    }
}