package com.binance4j.blvt.param

import com.binance4j.blvt.client.BLVTClient
import com.binance4j.core.annotation.Param
import com.binance4j.core.param.Params

/**
 * [BLVTClient.getLimitInfo] params.
 *
 * @param tokenName Token name.
 */
@Param
data class LimitInfoParams @JvmOverloads constructor(var tokenName: String? = null) : Params