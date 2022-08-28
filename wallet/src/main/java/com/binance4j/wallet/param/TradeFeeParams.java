package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getTradeFee} params.
 * 
 * @param symbol Trading pair we want the fees.
 */
@Param
public record TradeFeeParams(String symbol) implements Params {

}