package com.binance4j.blvt.param

import com.binance4j.blvt.client.BLVTClient
import com.binance4j.core.annotation.Param
import com.binance4j.core.param.Params

/**
 * [BLVTClient.subscribe] params.
 *
 * @property tokenName Token name.
 * @property cost      Cost to subscribe to.
 */
@Param
data class SubscriptionParams(var tokenName: String, var cost: String) : Params