package com.binance4j.fiat.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A fiat payment.
 * 
 * @param orderNo        Order No.
 * @param sourceAmount   Fiat trade amount.
 * @param fiatCurrency   Fiat token.
 * @param obtainAmount   Crypto trade amount.
 * @param cryptoCurrency Crypto token.
 * @param totalFee       Trade fee.
 * @param price          Price.
 * @param status         Status: {@code Processing}, {@code Completed}, {@code Failed}, {@code Refunded}.
 * @param createTime     Create time in ms.
 * @param updateTime     Update time in ms.
 */
@ApiModel("A fiat payment.")
public record Payment(@ApiModelProperty("Order No.") String orderNo, @ApiModelProperty("Fiat trade amount.") String sourceAmount,
		@ApiModelProperty("Fiat token.") String fiatCurrency, @ApiModelProperty("Crypto trade amount.") String obtainAmount,
		@ApiModelProperty("Crypto token.") String cryptoCurrency, @ApiModelProperty("Trade fee.") String totalFee, @ApiModelProperty("Price.") String price,
		@ApiModelProperty("Status: {@code Processing}, {@code Completed}, {@code Failed}, {@code Refunded}.") String status,
		@ApiModelProperty("Create time in ms.") long createTime, @ApiModelProperty("Update time in ms.") long updateTime) {
}
