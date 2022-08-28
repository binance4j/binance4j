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
@ApiModel("Purchase infos.")
public record Purchase(@ApiModelProperty("Amount.") String amount, @ApiModelProperty("Asset.") String asset,
		@ApiModelProperty("Create time.") long createTime,
		@ApiModelProperty("Lending type.") String lendingType, @ApiModelProperty("Lot.") long lot,
		@ApiModelProperty("Product name.") String productName,
		@ApiModelProperty("Purchase id.") long purchaseId, @ApiModelProperty("Status.") String status) {
}