package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profit.
 * 
 * @param time           Mining date in ms.
 * @param hashTransfer   Transferred Hashrate.
 * @param transferAmount Transferred Income.
 * @param dayHashRate    Daily Hashrate.
 * @param profitAmount   Earnings Amount.
 * @param coinName       Coin type.
 * @param type           Type. 0: Mining Wallet 5: Mining Address 7: Pool
 *                       Savings 8: Transferred 31: Income Transfer 32:
 *                       Hashrate Resale-Mining Wallet 33: Hashrate Resale-Pool
 *                       Savings
 * @param status         Status. 0: Unpaid 1: Paying 2: Paid
 */
@ApiModel("Account profit.")
public record Profit(@ApiModelProperty("Mining date in ms.") long time,
		@ApiModelProperty("Transferred Hashrate.") int type,
		@ApiModelProperty("Transferred Income.") long hashTransfer,
		@ApiModelProperty("Daily Hashrate.") String transferAmount,
		@ApiModelProperty("Earnings Amount.") long dayHashRate, @ApiModelProperty("Coin type.") String profitAmount,
		@ApiModelProperty("Type. 0: Mining Wallet 5: Mining Address 7: Pool Savings 8: Transferred 31: Income Transfer 32: Hashrate Resale-Mining Wallet 33: Hashrate Resale-Pool Savings") String coinName,
		@ApiModelProperty("Status. 0: Unpaid 1: Paying 2: Paid") int status) {
}