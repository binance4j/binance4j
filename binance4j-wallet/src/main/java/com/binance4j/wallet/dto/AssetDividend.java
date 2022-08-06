package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An asset divident.
 * 
 * @param amount  The divident amount.
 * @param enInfo  Info about the asset.
 * @param asset   The asset abbreviation.
 * @param id      The id.
 * @param divTime Dividend time in ms.
 * @param tranId  The transaction id.
 */
@ApiModel("")
public record AssetDividend(@ApiModelProperty("") String amount, @ApiModelProperty("") String enInfo, @ApiModelProperty("") String asset,
		@ApiModelProperty("") long id, @ApiModelProperty("") long divTime, @ApiModelProperty("") long tranId) {
}