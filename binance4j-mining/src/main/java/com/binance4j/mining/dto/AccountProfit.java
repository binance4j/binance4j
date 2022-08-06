package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profit.
 * 
 * @param time     Time in ms.
 * @param coinName Coin.
 * @param type     0:Referral 1：Refund 2：Rebate.
 * @param puid     Sub-account id.
 * @param subName  Mining account.
 * @param amount   Amount.
 */
@ApiModel("Account profit.")
public record AccountProfit(@ApiModelProperty("Time in ms.") long time, @ApiModelProperty("Coin.") String coinName,
		@ApiModelProperty("0:Referral 1：Refund 2：Rebate.") int type, @ApiModelProperty("Sub-account id.") int puid,
		@ApiModelProperty("Mining account.") String subName, @ApiModelProperty("Amount.") String amount) {
}
