package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Other profit.
 * 
 * @param time         Mining date.
 * @param coinName     Coin Name.
 * @param profitAmount Amount.
 * @param status       Status. 0: Unpaid 1: Paying 2：Paid
 * @param type         Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4:
 *                     Smart Pool 6: Income Transfer 7: Pool
 *                     Savings
 */
@ApiModel("Other profit.")
public record OtherProfit(@ApiModelProperty("Mining date.") long time, @ApiModelProperty("Coin Name.") String coinName,
		@ApiModelProperty("Amount.") int type,
		@ApiModelProperty("Status. 0: Unpaid 1: Paying 2：Paid") String profitAmount,
		@ApiModelProperty("Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4: Smart Pool 6: Income Transfer 7: Pool Savings") int status) {
}