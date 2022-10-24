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
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.market.service.ExchangeInfoService
import com.binance4j.connectors.spot.dto.NewOrder
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class NewOrderServiceTest : CustomTest() {
    private var client = Connectors.rest(testnetKey, testnetSecret).spot.testnet(true)
    private var tooLowOrder = NewOrder.limit(symbol, OrderSide.BUY, "0", "0", TimeInForce.GTC)
    private var quoteTooLowOrder = NewOrder.marketQuote(
        symbol, OrderSide.BUY, ExchangeInfoService.getSymbolInfo(symbol)!!.filters.minNotional.minNotional
            .toBigDecimal().divide("2".toBigDecimal()).toString()
    )
    private var tooHighOrder = NewOrder.limit(symbol, OrderSide.BUY, "1000000000", "1000000000", TimeInForce.GTC)
    private var goodOrder = NewOrder.limit(
        symbol, OrderSide.BUY,
        // Getting max quantity allowed in filter
        ExchangeInfoService.getSymbolInfo(symbol)!!.filters.lotSize.maxQty,
        // Getting average price
        Connectors.rest.market.getAveragePrice(symbol).sync().price,
        TimeInForce.GTC
    )

    @Test
    fun `It Must throw NullPointerException on symbol`() {
        assertThrows<NullPointerException> {
            NewOrderService.isPriceTooLow(NewOrder.market("", OrderSide.BUY, ""))
        }
    }

    @Test
    fun `It Must throw NullPointerException price`() {
        assertThrows<NullPointerException> {
            NewOrderService.isPriceTooLow(NewOrder.market("", OrderSide.BUY, ""))
        }
    }

    @Test
    fun `It Must throw NullPointerException on quantity`() {
        assertThrows<NullPointerException> {
            NewOrderService.isPriceTooLow(NewOrder.marketQuote("", OrderSide.BUY, ""))
        }
    }

    @Test
    fun `Order price must be too low`() = assertTrue(NewOrderService.isPriceTooLow(tooLowOrder))

    @Test
    fun `Order price must be too high`() = assertTrue(NewOrderService.isPriceTooHigh(tooHighOrder))

    @Test
    fun `Price must be valid`() = assertTrue(NewOrderService.validatePrice(goodOrder))

    @Test
    fun `Order quantity must be too low`() = assertTrue(NewOrderService.isQuantityTooLow(tooLowOrder))

    @Test
    fun `Order quantity must be too high`() = assertTrue(NewOrderService.isQuantityTooHigh(tooHighOrder))

    @Test
    fun `Quantity must be valid`() = assertTrue(NewOrderService.validateQuantity(goodOrder))

    @Test
    fun `Quote quantity must be too low`() = assertTrue(NewOrderService.isQuoteQuantityTooLow(quoteTooLowOrder))
}