package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan interest rate.
 * 
 * @param asset             Related coin.
 * @param dailyInterestRate Daily interest rate.
 * @param timestamp         Timestamp of the applied interest rate in ms.
 * @param vipLevel          Account VIP level.
 */
@ApiModel("A loan interest rate.")
public record InterestRate(@ApiModelProperty("Related coin.") String asset,
		@ApiModelProperty("Daily interest rate.") String dailyInterestRate,
		@ApiModelProperty("Timestamp of the applied interest rate in ms.") long timestamp,
		@ApiModelProperty("Account VIP level.") int vipLevel) {
}