package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dribblets.
 * 
 * @param operateTime              Operation timestamp.
 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
 * @param totalServiceChargeAmount Total service charge amount for this exchange.
 * @param transId                  Transaction id.
 * @param userAssetDribbletDetails Details of this exchange.
 */
@ApiModel("Dribblets.")
public record UserAssetDribblets(@ApiModelProperty("Operation timestamp.") long operateTime,
		@ApiModelProperty("Total transfered BNB amount for this exchange.") String totalTransferedAmount,
		@ApiModelProperty("Total service charge amount for this exchange.") String totalServiceChargeAmount, @ApiModelProperty("Transaction id.") long transId,
		@ApiModelProperty("Details of this exchange.") List<UserAssetDribbletDetails> userAssetDribbletDetails) {
}