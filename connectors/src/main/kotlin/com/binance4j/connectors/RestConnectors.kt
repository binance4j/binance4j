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

import com.binance4j.blvt.client.BLVTClient
import com.binance4j.c2c.client.C2CClient
import com.binance4j.convert.client.ConvertClient
import com.binance4j.fiat.client.FiatClient
import com.binance4j.loan.client.LoanClient
import com.binance4j.margin.client.MarginClient
import com.binance4j.market.client.MarketClient
import com.binance4j.mining.client.MiningClient
import com.binance4j.nft.client.NFTClient
import com.binance4j.pay.client.PayClient
import com.binance4j.portfoliomargin.client.PortfolioMarginClient
import com.binance4j.rebate.client.RebateClient
import com.binance4j.savings.client.SavingsClient
import com.binance4j.spot.client.SpotClient
import com.binance4j.staking.client.StakingClient
import com.binance4j.vision.client.VisionSpotClient
import com.binance4j.wallet.client.WalletClient
import com.binance4j.websocket.client.UserDataClient

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
		this.key = key
		this.secret = secret
		return this
	}
}