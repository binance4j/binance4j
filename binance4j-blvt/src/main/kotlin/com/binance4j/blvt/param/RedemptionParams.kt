package com.binance4j.blvt.param

import com.binance4j.blvt.client.BLVTClient
import com.binance4j.core.annotation.Param
import com.binance4j.core.param.Params

/**
 * [BLVTClient.redeem] params.
 *
 * @property tokenName Token name.
 * @property amount    Amount to redeem.
 */
@Param
data class RedemptionParams(var tokenName: String, var amount: String) : Params