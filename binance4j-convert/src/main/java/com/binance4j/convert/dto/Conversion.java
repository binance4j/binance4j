package com.binance4j.convert.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A conversion of an asset into another.
 * 
 * @param quoteId      Quote Id.
 * @param orderId      Order Id.
 * @param orderStatus  Order Status.
 * @param fromAsset    From Asset.
 * @param fromAmount   From Amount.
 * @param toAsset      To Asset.
 * @param toAmount     To Amount.
 * @param ratio        Ratio.
 * @param inverseRatio Inverse Ratio.
 * @param createTime   Create Time in ms.
 */
@ApiModel("A conversion of an asset into another.")
public record Conversion(@ApiModelProperty("Quote Id.") String quoteId, @ApiModelProperty("Order Id.") long orderId,
		@ApiModelProperty("Order Status.") String orderStatus, @ApiModelProperty("From Asset.") String fromAsset,
		@ApiModelProperty("From Amount.") String fromAmount, @ApiModelProperty("To Asset.") String toAsset, @ApiModelProperty("To Amount.") String toAmount,
		@ApiModelProperty("Ratio.") String ratio, @ApiModelProperty("Inverse Ratio.") String inverseRatio,
		@ApiModelProperty("Create Time in ms.") long createTime) {
}
