package com.binance4j.c2c.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A C2C Trade.
 * 
 * @param orderNumber         Order number.
 * @param advNo               Adv No.
 * @param tradeType           Trade type.
 * @param asset               Asset.
 * @param fiat                Fiat.
 * @param fiatSymbol          Fiat symbol.
 * @param amount              Amount.
 * @param totalPrice          Total price.
 * @param unitPrice           Unit price.
 * @param orderStatus         Order status.
 * @param createTime          Create time.
 * @param commission          Commission.
 * @param counterPartNickName Counter part nickname.
 * @param advertisementRole   Advertisement role.
 */
@ApiModel("A C2C Trade.")
public record Trade(@ApiModelProperty("Order number.") String orderNumber, @ApiModelProperty("Adv No.") long advNo,
		@ApiModelProperty("Trade type.") String tradeType, @ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Fiat.") String fiat,
		@ApiModelProperty("Fiat symbol.") String fiatSymbol, @ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Total price.") String totalPrice,
		@ApiModelProperty("Unit price.") String unitPrice, @ApiModelProperty("Order status.") String orderStatus,
		@ApiModelProperty("Create time.") long createTime, @ApiModelProperty("Commission.") String commission,
		@ApiModelProperty("Counter part nickname.") String counterPartNickName,
		@ApiModelProperty("Advertisement role.") String advertisementRole) {
}
