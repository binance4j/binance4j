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
package com.binance4j.connectors

import com.binance4j.connectors.blvt.client.BLVTClient
import com.binance4j.connectors.c2c.client.C2CClient
import com.binance4j.connectors.convert.client.ConvertClient
import com.binance4j.connectors.fiat.client.FiatClient
import com.binance4j.connectors.loan.client.LoanClient
import com.binance4j.connectors.margin.client.MarginClient
import com.binance4j.connectors.market.client.MarketClient
import com.binance4j.connectors.mining.client.MiningClient
import com.binance4j.connectors.nft.client.NFTClient
import com.binance4j.connectors.pay.client.PayClient
import com.binance4j.connectors.portfoliomargin.client.PortfolioMarginClient
import com.binance4j.connectors.rebate.client.RebateClient
import com.binance4j.connectors.savings.client.SavingsClient
import com.binance4j.connectors.spot.client.SpotClient
import com.binance4j.connectors.staking.client.StakingClient
import com.binance4j.connectors.vision.client.VisionSpotClient
import com.binance4j.connectors.wallet.client.WalletClient
import com.binance4j.connectors.websocket.client.UserDataClient

/** REST Connectors. */
object RestConnectors {
    var key: String = ""
    var secret: String = ""

    /** [BLVTClient] singleton. */
    val blvt = BLVTClient

    /** [C2CClient] singleton. */
    val c2c = C2CClient

    /** [ConvertClient] singleton. */
    val convert = ConvertClient

    /** [FiatClient] singleton.*/
    val fiat = FiatClient

    /** [LoanClient] singleton. */
    val loan = LoanClient

    /** [MarginClient] singleton. */
    val margin = MarginClient

    /** [MarketClient] singleton. */
    val market = MarketClient

    /** [MiningClient] singleton. */
    val mining = MiningClient

    /** [NFTClient] singleton. */
    val nft = NFTClient

    /** [PayClient] singleton. */
    val pay = PayClient

    /** [PortfolioMarginClient] singleton. */
    val portfolio = PortfolioMarginClient

    /** [RebateClient] singleton. */
    val rebate = RebateClient

    /** [SavingsClient] singleton. */
    val savings = SavingsClient

    /** [SpotClient] singleton. */
    val spot = SpotClient

    /** [SpotClient] singleton. */
    val staking = StakingClient

    /** [VisionSpotClient] singleton. */
    val visionSpot = VisionSpotClient

    /** [WalletClient] singleton. */
    val wallet = WalletClient

    /** [UserDataClient] singleton. */
    val user = UserDataClient

    /**
     * Updates API keys.
     *
     * @param key    New public key.
     * @param secret New secret key.
     */
    fun updateKeys(key: String, secret: String): RestConnectors {
        RestConnectors.key = key
        RestConnectors.secret = secret
        return this
    }
}