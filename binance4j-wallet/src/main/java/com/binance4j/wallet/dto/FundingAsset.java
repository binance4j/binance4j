package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders,@ApiModelProperty("")
 * Binance Payment,@ApiModelProperty("") Binance Card and Crypto Deposit/Withdrawal.
 * 
 * @param asset        The asset abbreviation.
 * @param free         The available balancve.
 * @param locked       The locked balance (volume in the order book).
 * @param freeze       The freezed balance. Locked by binance (?)
 * @param withdrawing  The pending volume withdrawing.
 * @param btcValuation The value of the balance in BTC.
 */
@ApiModel("")
public record FundingAsset(@ApiModelProperty("") String asset, @ApiModelProperty("") String free, @ApiModelProperty("") String locked,
		@ApiModelProperty("") String freeze, @ApiModelProperty("") String withdrawing, @ApiModelProperty("") String btcValuation) {
}