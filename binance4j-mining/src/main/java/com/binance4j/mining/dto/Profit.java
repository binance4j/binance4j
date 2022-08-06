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
 * @param type           Type.
 *                           <ul>
 *                           <li>0: Mining Wallet</li>
 *                           <li>5: Mining Address</li>
 *                           <li>7: Pool Savings</li>
 *                           <li>8: Transferred</li>
 *                           <li>31: Income Transfer</li>
 *                           <li>32: Hashrate Resale-Mining Wallet</li>
 *                           <li>33: Hashrate Resale-Pool Savings</li>
 *                           </ul>
 * @param status         Status.
 *                           <ul>
 *                           <li>0: Unpaid</li>
 *                           <li>1: Paying</li>
 *                           <li>2: Paid</li>
 *                           </ul>
 */
@ApiModel("")
public record Profit(@ApiModelProperty("") long time, @ApiModelProperty("") int type, @ApiModelProperty("") long hashTransfer,
		@ApiModelProperty("") String transferAmount, @ApiModelProperty("") long dayHashRate, @ApiModelProperty("") String profitAmount,
		@ApiModelProperty("") String coinName, @ApiModelProperty("") int status) {
}