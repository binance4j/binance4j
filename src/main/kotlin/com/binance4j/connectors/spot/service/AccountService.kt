package com.binance4j.connectors.spot.service

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.dto.AssetBalance
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.spot.dto.Account

/** Service to manipulate an [Account] */
object AccountService {

    /**
     * Get the asset's balances in a list of balances.
     *
     * @param asset The asset to we want the balance.
     * @param balances The list of balances to search in.
     *
     * @return The balance of the given asset or null.
     */
    @JvmStatic
    @Throws(ApiException::class)
    fun getBalance(asset: String, balances: List<AssetBalance>): AssetBalance? = balances.filter { b -> b.asset == asset }.getOrNull(0)

    /**
     * Fetches the SPOT account and get the asset's balance (sync).
     *
     * @param asset The asset to we want the balance.
     *
     * @return The balance of the given asset or null.
     */
    @JvmStatic
    @Throws(ApiException::class)
    fun getBalance(asset: String): AssetBalance? = getBalance(asset, Connectors.rest.spot.getAccount().sync().balances)

    /**
     * Fetches the SPOT account and get the asset's balance (async).
     *
     * @param asset The asset to we want the balance.
     * @param callback Callback to handle the API call.
     *
     * @return The balance of the given asset or null.
     */
    @JvmStatic
    fun getBalance(asset: String, callback: (balance: AssetBalance?, exception: ApiException?) -> Unit) = Connectors.rest.spot.getAccount().async { res, e ->
        callback.invoke(getBalance(asset, res?.balances ?: emptyList()), e)
    }
}