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

package com.binance4j.connectors.market.service

import com.binance4j.connectors.market.dto.SymbolInfo
import java.math.BigDecimal

/**
 * Service giving additional info about a [SymbolInfo].
 * @param symbolInfo [SymbolInfo] to manipulate.
 */
class SymbolInfoService(var symbolInfo: SymbolInfo) {
    /** Is limit trading allowed? */
    val isLimitTradingAllowed = symbolInfo.orderTypes.contains("LIMIT")

    /** Is limit maker trading allowed? */
    val isLimitMakerTradingAllowed = symbolInfo.orderTypes.contains("LIMIT_MAKER")

    /** Is market trading allowed? */
    val isMarketTradingAllowed = symbolInfo.orderTypes.contains("MARKET")

    /** Is stop loss trading allowed? */
    val isStopLossTradingAllowed = symbolInfo.orderTypes.contains("STOP_LOSS")

    /** Is stop loss limit trading allowed? */
    val isStopLossLimitTradingAllowed = symbolInfo.orderTypes.contains("STOP_LOSS_LIMIT")

    /** Is take profit trading allowed? */
    val isTakeProfitTradingAllowed = symbolInfo.orderTypes.contains("TAKE_PROFIT")

    /** Is take profit limit trading allowed? */
    val isTakeProfitLimitTradingAllowed = symbolInfo.orderTypes.contains("TAKE_PROFIT_LIMIT")

    /** Can symbol be traded? */
    val canTrade = symbolInfo.status == "TRADING"

    /** Is market data for the symbol still generated? */
    val isMarketDataGenerated = symbolInfo.status == "TRADING" || symbolInfo.status == "HALT"

    /** Decimal precision of the order quantity. */
    val lotScale = BigDecimal(symbolInfo.filters.lotSize.stepSize).stripTrailingZeros().scale()

    /** Decimal precision of the order price. */
    val priceScale = BigDecimal(symbolInfo.filters.price.tickSize).stripTrailingZeros().scale()
}