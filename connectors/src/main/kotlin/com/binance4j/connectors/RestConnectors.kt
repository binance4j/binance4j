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
import com.binance4j.core.client.RestClient
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

/**
 * REST Connectors container.
 * @param key    API key
 * @param secret API secret
 */
class RestConnectors(var key: String, var secret: String) {

    /** Inner [BLVTClient]. */
    private lateinit var blvtClient: BLVTClient

    /** @return instance of [BLVTClient]. */
    fun blvt(): BLVTClient {
        if (!::blvtClient.isInitialized) blvtClient = BLVTClient(key, secret)
        updateClientKeys(blvtClient)
        return blvtClient
    }

    /** Inner [C2CClient]. */
    private lateinit var c2cClient: C2CClient

    /** @return instance of [C2CClient]. */
    fun c2c(): C2CClient {
        if (!::c2cClient.isInitialized) c2cClient = C2CClient(key, secret)
        updateClientKeys(c2cClient)
        return c2cClient
    }

    /** Inner [ConvertClient]. */
    private lateinit var convertClient: ConvertClient

    /** @return instance of [ConvertClient]. */
    fun convert(): ConvertClient {
        if (!::convertClient.isInitialized) convertClient = ConvertClient(key, secret)
        updateClientKeys(convertClient)
        return convertClient
    }

    /** Inner [FiatClient].*/
    private lateinit var fiatClient: FiatClient

    /** @return instance of [FiatClient]. */
    fun fiat(): FiatClient {
        if (!::fiatClient.isInitialized) fiatClient = FiatClient(key, secret)
        updateClientKeys(fiatClient)
        return fiatClient
    }

    /**
     * Inner [LoanClient].
     */
    private lateinit var loanClient: LoanClient

    /** @return instance of [LoanClient]. */
    fun loan(): LoanClient {
        if (!::loanClient.isInitialized) loanClient = LoanClient(key, secret)
        updateClientKeys(loanClient)
        return loanClient
    }

    /** Inner [MarginClient]. */
    private lateinit var marginClient: MarginClient

    /** @return instance of [MarginClient]. */
    fun margin(): MarginClient {
        if (!::marginClient.isInitialized) marginClient = MarginClient(key, secret)
        updateClientKeys(marginClient)
        return marginClient
    }

    /**
     * Inner [MarketClient].
     */
    private lateinit var marketClient: MarketClient

    /** @return instance of [MarketClient]. */
    fun market(): MarketClient {
        if (!::marketClient.isInitialized) marketClient = MarketClient(key, secret)
        updateClientKeys(marketClient)
        return marketClient
    }


    /** Inner [MiningClient]. */
    private lateinit var miningClient: MiningClient

    /** @return instance of [MiningClient]. */
    fun mining(): MiningClient {
        if (!::miningClient.isInitialized) miningClient = MiningClient(key, secret)
        updateClientKeys(miningClient)
        return miningClient
    }

    /**
     * Inner [NFTClient].
     */
    private lateinit var nftClient: NFTClient

    /** @return instance of [NFTClient]. */
    fun nft(): NFTClient {
        if (!::nftClient.isInitialized) nftClient = NFTClient(key, secret)
        updateClientKeys(nftClient)
        return nftClient
    }

    /** Inner [PayClient]. */
    private lateinit var payClient: PayClient

    /** @return instance of [PayClient]. */
    fun pay(): PayClient {
        if (!::payClient.isInitialized) payClient = PayClient(key, secret)
        updateClientKeys(payClient)
        return payClient
    }

    /** Inner [PortfolioMarginClient]. */
    private lateinit var portfolioMarginClient: PortfolioMarginClient

    /** @return instance of [PortfolioMarginClient]. */
    fun portfolio(): PortfolioMarginClient {
        if (!::portfolioMarginClient.isInitialized) portfolioMarginClient = PortfolioMarginClient(key, secret)
        updateClientKeys(portfolioMarginClient)
        return portfolioMarginClient
    }

    /** Inner [RebateClient]. */
    private lateinit var rebateClient: RebateClient

    /** @return instance of [RebateClient]. */
    fun rebate(): RebateClient {
        if (!::rebateClient.isInitialized) rebateClient = RebateClient(key, secret)
        updateClientKeys(rebateClient)
        return rebateClient
    }

    /** Inner [SavingsClient]. */
    private lateinit var savingsClient: SavingsClient

    /** @return instance of [SavingsClient]. */
    fun savings(): SavingsClient {
        if (!::savingsClient.isInitialized) savingsClient = SavingsClient(key, secret)
        updateClientKeys(savingsClient)
        return savingsClient
    }

    /** Inner [SpotClient]. */
    private lateinit var spotClient: SpotClient

    /** @return instance of [SpotClient]. */
    fun spot(): SpotClient {
        if (!::spotClient.isInitialized) spotClient = SpotClient(key, secret)
        updateClientKeys(spotClient)
        return spotClient
    }

    /** Inner [StakingClient]. */
    private lateinit var stakingClient: StakingClient

    /** @return instance of [StakingClient]. */
    fun staking(): StakingClient {
        if (!::stakingClient.isInitialized) stakingClient = StakingClient(key, secret)
        updateClientKeys(stakingClient)
        return stakingClient
    }

    /** Inner [VisionSpotClient]. */
    private lateinit var visionSpotClient: VisionSpotClient

    /** @return instance of [VisionSpotClient]. */
    fun visionSpot(): VisionSpotClient {
        if (!::visionSpotClient.isInitialized) visionSpotClient = VisionSpotClient()
        return visionSpotClient
    }

    /** Inner [WalletClient]. */
    private lateinit var walletClient: WalletClient

    /** @return instance of [WalletClient]. */
    fun wallet(): WalletClient {
        if (!::walletClient.isInitialized) walletClient = WalletClient(key, secret)
        updateClientKeys(walletClient)
        return walletClient
    }

    /** Inner [UserDataClient]. */
    private lateinit var userDataClient: UserDataClient

    /** @return instance of [UserDataClient]. */
    fun user(): UserDataClient {
        if (!::userDataClient.isInitialized) userDataClient = UserDataClient(key, secret)
        updateClientKeys(userDataClient)
        return userDataClient
    }

    /**
     * Updates the API keys.
     *
     * @param key    New public key.
     * @param secret New secret key.
     */
    fun updateKeys(key: String, secret: String) {
        this.key = key
        this.secret = secret
    }

    /**
     * Will update the client's keys if they have changed in the container.
     *
     * @param client client.
     */
    private fun updateClientKeys(client: RestClient<*>) {
        if (client.key != key || client.secret != secret) {
            client.updateKeys(key, secret)
        }
    }
}