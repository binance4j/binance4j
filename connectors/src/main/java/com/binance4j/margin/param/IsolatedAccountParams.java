package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.getIsolatedAccount] params.
 * 
 * @param symbols Max 5 symbols can be sent; separated by ",".
 */
data class IsolatedAccountParams(String symbols) : Params {
}