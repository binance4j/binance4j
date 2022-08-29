package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Other profit.
 * 
 * @property time         Mining date.
 * @property coinName     Coin Name.
 * @property profitAmount Amount.
 * @property status       Status. 0: Unpaid 1: Paying 2：Paid
 * @property type         Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4:
 *                     Smart Pool 6: Income Transfer 7: Pool
 *                     Savings
 */
@ApiModel("Other profit.")
data class OtherProfit(
@ApiModelProperty("Mining date.")
 val time : Long,
@ApiModelProperty("Coin Name.")
 val coinName : String,
@ApiModelProperty("Amount.")
 var type:Int = 0,
@ApiModelProperty("Status. 0: Unpaid 1: Paying 2：Paid") String profitAmount,
@ApiModelProperty("Type.1: Merged Mining 2: Activity Bonus 3: Rebate 4: Smart Pool 6: Income Transfer 7: Pool Savings")
int status)
{
}