package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Purchase infos.
 * 
 * @param amount      Amount.
 * @param asset       Asset.
 * @param createTime  Create time.
 * @param lendingType Lending type.
 * @param lot         Lot.
 * @param productName Product name.
 * @param purchaseId  Purchase id.
 * @param status      Status.
 */
@ApiModel("")
public record Purchase(@ApiModelProperty("") String amount, @ApiModelProperty("") String asset, @ApiModelProperty("") long createTime,
		@ApiModelProperty("") String lendingType, @ApiModelProperty("") long lot, @ApiModelProperty("") String productName,
		@ApiModelProperty("") long purchaseId, @ApiModelProperty("") String status) {
}