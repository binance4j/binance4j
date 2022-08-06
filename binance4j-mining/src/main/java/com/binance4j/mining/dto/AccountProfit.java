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
@ApiModel("")
public record AccountProfit(@ApiModelProperty("") long time, @ApiModelProperty("") String coinName, @ApiModelProperty("") int type,
		@ApiModelProperty("") int puid, @ApiModelProperty("") String subName, @ApiModelProperty("") String amount) {
}
