package com.binance4j.blvt.param

import com.binance4j.blvt.client.BLVTClient
import com.binance4j.core.annotation.Param
import com.binance4j.core.param.Params

/**
 * [BLVTClient.getRedemptions] params.
 *
 * @property tokenName Token name.
 * @property id        Subscription id.
 */
@Param
data class TransactionRecordParams @JvmOverloads constructor(var tokenName: String? = null, var id: Long? = null) : Params