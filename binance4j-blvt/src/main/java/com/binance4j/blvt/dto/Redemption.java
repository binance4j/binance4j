package com.binance4j.blvt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A BLVT redemption.
 * 
 * @param id          Id.
 * @param tokenName   Token name.
 * @param amount      Amount.
 * @param nav         Nav.
 * @param fee         Fee.
 * @param totalCharge Total charge.
 * @param timestamp   Timestamp in ms.
 */
@ApiModel("A BLVT redemption.")
public record Redemption(@ApiModelProperty("Id.") long id, @ApiModelProperty("Token name.") String tokenName, @ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Nav.") String nav, @ApiModelProperty("Fee.") String fee, @ApiModelProperty("Total charge.") String totalCharge,
		@ApiModelProperty("Timestamp in ms.") long timestamp) {
}