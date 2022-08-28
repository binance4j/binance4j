package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The Funding Wallet balance reflects a user's total crypto balance from P2P
 * buy/sell orders, Binance Payment, Binance
 * Card and Crypto Deposit/Withdrawal.
 * 
 * @param asset        Asset abbreviation.
 * @param free         Available balancve.
 * @param locked       Locked balance (volume in the order book).
 * @param freeze       Freezed balance. Locked by binance (?)
 * @param withdrawing  Pending volume withdrawing.
 * @param btcValuation Value of the balance in BTC.
 */
@ApiModel("The Funding Wallet balance reflects a user's total crypto balance from P2P buy/sell orders, Binance Payment, Binance Card and Crypto Deposit/Withdrawal.")
public record FundingAsset(@ApiModelProperty("Asset abbreviation.") String asset,
		@ApiModelProperty("Available balancve.") String free,
		@ApiModelProperty("Locked balance (volume in the order book).") String locked,
		@ApiModelProperty("Freezed balance. Locked by binance (?)") String freeze,
		@ApiModelProperty("Pending volume withdrawing.") String withdrawing,
		@ApiModelProperty("Value of the balance in BTC.") String btcValuation) {
}