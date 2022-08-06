package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Other profit.
 * 
 * @param time         Mining date.
 * @param coinName     Coin Name.
 * @param profitAmount Amount.
 * @param status       Status.
 *                         <ul>
 *                         <li>0: Unpaid</li>
 *                         <li>1: Paying</li>
 *                         <li>2：Paid</li>
 *                         </ul>
 * @param type         Type.
 *                         <ul>
 *                         <li>1: Merged Mining</li>
 *                         <li>2: Activity Bonus</li>
 *                         <li>3: Rebate</li>
 *                         <li>4: Smart Pool</li>
 *                         <li>6: Income Transfer</li>
 *                         <li>7: Pool Savings</li>
 *                         </ul>
 */
@ApiModel("")
public record OtherProfit(@ApiModelProperty("") long time, @ApiModelProperty("") String coinName, @ApiModelProperty("") int type,
		@ApiModelProperty("") String profitAmount, @ApiModelProperty("") int status) {
}