package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details of a supported asset.
 * 
 * @param minWithdrawAmount The minimal withdraw amount.
 * @param depositStatus     The deposit status (false if ALL of networks' are false).
 * @param withdrawFee       The withdraw fee.
 * @param withdrawStatus    The withdraw status (false if ALL of networks' are false).
 * @param depositTip        The reason of the status.
 */
@ApiModel("")
public record AssetDetail(@ApiModelProperty("") String minWithdrawAmount, @ApiModelProperty("") boolean depositStatus, @ApiModelProperty("") Float withdrawFee,
		@ApiModelProperty("") boolean withdrawStatus, @ApiModelProperty("") String depositTip) {
	/** @return Reason. */
	public String depositTip() {
		return depositTip == null ? "" : depositTip;
	}
}