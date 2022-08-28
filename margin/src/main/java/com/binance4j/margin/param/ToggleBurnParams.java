package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * [MarginClient.toggleBNBBurnOnSpotTradeAndMarginInterest] params.
 * 
 * @param spotBNBBurn     Use BNB to pay for trading fees on SPOT?
 * @param interestBNBBurn Use BNB to pay for margin loan's interest?
 */
@Param
data class ToggleBurnParams(Boolean spotBNBBurn, Boolean interestBNBBurn) : Params {

}