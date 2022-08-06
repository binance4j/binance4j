package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dribblets.
 * 
 * @param operateTime              The operation timestamp.
 * @param totalTransferedAmount    Total transfered BNB amount for this exchange.
 * @param totalServiceChargeAmount Total service charge amount for this exchange.
 * @param transId                  The transaction id.
 * @param userAssetDribbletDetails Details of this exchange.
 */
@ApiModel("")
public record UserAssetDribblets(@ApiModelProperty("") long operateTime, @ApiModelProperty("") String totalTransferedAmount,
		@ApiModelProperty("") String totalServiceChargeAmount, @ApiModelProperty("") long transId,
		@ApiModelProperty("") List<UserAssetDribbletDetails> userAssetDribbletDetails) {
}