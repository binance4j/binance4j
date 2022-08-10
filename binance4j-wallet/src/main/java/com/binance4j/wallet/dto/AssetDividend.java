package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset divident.
 * 
 * @param amount  Divident amount.
 * @param enInfo  Info about the asset.
 * @param asset   Asset abbreviation.
 * @param id      Id.
 * @param divTime Dividend time in ms.
 * @param tranId  Transaction id.
 */
@ApiModel("An asset divident.")
public record AssetDividend(@ApiModelProperty("Divident amount.") String amount,
		@ApiModelProperty("Info about the asset.") String enInfo,
		@ApiModelProperty("Asset abbreviation.") String asset, @ApiModelProperty("Id.") long id,
		@ApiModelProperty("Dividend time in ms.") long divTime,
		@ApiModelProperty("Transaction id.") long tranId) {
}